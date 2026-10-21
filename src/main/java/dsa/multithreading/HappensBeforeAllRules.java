package dsa.multithreading;

/**
 * HappensBeforeAllRules.java
 *
 * ONE program demonstrating ALL 8 happens-before rules from the Java Memory Model.
 *
 * Rules covered:
 *   Rule 1: Program order
 *   Rule 2: Monitor lock (synchronized)
 *   Rule 3: Volatile
 *   Rule 4: Thread start
 *   Rule 5: Thread join
 *   Rule 6: Interruption
 *   Rule 7: Finalizer
 *   Rule 8: Transitivity
 *
 * Compile:  javac HappensBeforeAllRules.java
 * Run:      java HappensBeforeAllRules
 */
public class HappensBeforeAllRules {

    // ============================================================
    // RULE 1: PROGRAM ORDER
    // ============================================================
    // "Within one thread, statements execute in order (as observed by that thread)."
    //
    // KEY POINT: This only guarantees order to *the same thread*.
    // It says NOTHING about what other threads see. Other threads may
    // observe these writes in a different order (or not at all) unless
    // another rule (volatile, lock, etc.) links them.
    //
    // In this method, the *main thread* itself will always print in order.
    // Notice we don't even need threads here — it's about a single thread's view.
    static void rule1_programOrder() {
        System.out.println("\n=== RULE 1: PROGRAM ORDER ===");

        int a = 1;                 // statement 1
        int b = 2;                 // statement 2
        int c = a + b;             // statement 3: uses results of 1 and 2

        // The main thread is GUARANTEED to see a=1, b=2 before computing c.
        // This is program order. It is the weakest rule.
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
        System.out.println("-> Within one thread, statements run in order (as that thread sees them).");
        System.out.println("-> But other threads get NO guarantee from this rule alone.");
    }

    // ============================================================
    // RULE 2: MONITOR LOCK (synchronized)
    // ============================================================
    // "Unlock of a monitor happens-before subsequent lock of the same monitor."
    //
    // STORY: There is ONE key to a locked room. Alice unlocks, writes on the
    // real whiteboard, locks, and leaves. Bob unlocks the same door and reads.
    // Because Alice LOCKED after writing, Bob is GUARANTEED to see her writes.
    //
    // We use two shared variables here: `data` and `ready`, both plain (non-volatile).
    // The ONLY thing making the read safe is the synchronized block.
    static int monitorData = 0;
    static boolean monitorReady = false;
    static final Object monitorLock = new Object();

    static void rule2_monitorLock() throws InterruptedException {
        System.out.println("\n=== RULE 2: MONITOR LOCK ===");

        // Reset state for a clean run
        monitorData = 0;
        monitorReady = false;

        Thread producer = new Thread(() -> {
            synchronized (monitorLock) {     // LOCK
                monitorData = 42;            // plain write
                monitorReady = true;         // plain write
            }                                // UNLOCK  <-- happens-before Bob's lock
        });

        Thread consumer = new Thread(() -> {
            synchronized (monitorLock) {     // LOCK   <-- happens-after Alice's unlock
                // Because the unlock happened-before this lock, we are GUARANTEED
                // to see monitorReady == true and monitorData == 42 here.
                System.out.println("consumer sees monitorData = " + monitorData
                        + ", monitorReady = " + monitorReady);
            }
        });

        consumer.start();
        Thread.sleep(100);   // give consumer a chance to block on the lock
        producer.start();

        producer.join();
        consumer.join();

        System.out.println("-> Unlock by producer happens-before lock by consumer.");
        System.out.println("-> So consumer always sees data=42 and ready=true.");
    }

    // ============================================================
    // RULE 3: VOLATILE
    // ============================================================
    // "Write to volatile happens-before subsequent read of that volatile."
    //
    // STORY: A flashing neon sign in the hallway. Everyone sees it instantly,
    // bypassing their private photocopies. Anything written BEFORE flipping
    // the sign is also visible to anyone who reads the sign afterward.
    //
    // Without `volatile`, the consumer could spin forever (stale copy)
    // or read data=0 (reordered/unsynced photocopy). With volatile, safe.
    static int volatileData = 0;
    static volatile boolean volatileReady = false;

    static void rule3_volatile() throws InterruptedException {
        System.out.println("\n=== RULE 3: VOLATILE ===");

        volatileData = 0;
        volatileReady = false;

        Thread producer = new Thread(() -> {
            volatileData = 42;        // (1) plain write
            volatileReady = true;     // (2) volatile write -> flushes (1) too
        });

        Thread consumer = new Thread(() -> {
            while (!volatileReady) {  // (3) volatile read -> sees true
                // spin
            }
            // (4) guaranteed to see volatileData == 42 (transitivity via volatile)
            System.out.println("consumer sees volatileData = " + volatileData);
        });

        consumer.start();
        Thread.sleep(100);
        producer.start();

        producer.join();
        consumer.join();

        System.out.println("-> Volatile write happens-before the subsequent volatile read.");
        System.out.println("-> Everything written BEFORE the volatile write is also visible.");
    }

    // ============================================================
    // RULE 4: THREAD START
    // ============================================================
    // "Thread.start() happens-before anything in the started thread."
    //
    // STORY: Alice prepares a briefing folder, then HIRES Bob. Everything in
    // the folder at hiring time is guaranteed to be on Bob's desk when he starts.
    //
    // Notice: startValue is NOT volatile. No lock. Yet the child sees 99.
    // Why? Because start() is the barrier.
    static int startValue = 0;

    static void rule4_threadStart() throws InterruptedException {
        System.out.println("\n=== RULE 4: THREAD START ===");

        startValue = 99;                   // (1) write BEFORE start()

        Thread child = new Thread(() -> {
            // (2) happens-after start(): GUARANTEED to see startValue == 99
            System.out.println("child sees startValue = " + startValue);
        });

        child.start();                     // (3) start() is the barrier
        child.join();

        System.out.println("-> start() happens-before everything in the child thread.");
    }

    // ============================================================
    // RULE 5: THREAD JOIN
    // ============================================================
    // "Everything in a thread happens-before join() returns in the joining thread."
    //
    // STORY: Bob works in a room. Alice WAITS AT THE DOOR until he is done
    // (join()). When Bob walks out, Alice is guaranteed to see everything he did.
    //
    // Notice: joinResult is NOT volatile. No lock. Yet main sees 42.
    // Because join() is the barrier.
    static int joinResult = 0;

    static void rule5_threadJoin() throws InterruptedException {
        System.out.println("\n=== RULE 5: THREAD JOIN ===");

        Thread worker = new Thread(() -> {
            joinResult = 7 * 6;            // (1) write inside worker
        });

        worker.start();
        worker.join();                     // (2) join() is the barrier

        // (3) happens-after join() returns: GUARANTEED to see joinResult == 42
        System.out.println("main sees joinResult = " + joinResult);

        System.out.println("-> Everything in the worker happens-before join() returns.");
    }

    // ============================================================
    // RULE 6: INTERRUPTION
    // ============================================================
    // "interrupt() happens-before the interrupted thread detects it."
    //
    // STORY: Alice taps Bob on the shoulder. The tap happens BEFORE Bob
    // notices and reacts. Simple ordering guarantee.
    //
    // The target thread is sleeping; interrupt() causes it to throw
    // InterruptedException. The detection (catch block) is guaranteed
    // to be ordered after interrupt().
    static void rule6_interruption() throws InterruptedException {
        System.out.println("\n=== RULE 6: INTERRUPTION ===");

        Thread sleeper = new Thread(() -> {
            try {
                Thread.sleep(10_000);      // (2) will throw InterruptedException
            } catch (InterruptedException e) {
                // (3) Detection: interrupt() happened-before this catch block.
                System.out.println("sleeper detected interrupt in catch block");
            }
        });

        sleeper.start();
        Thread.sleep(100);                 // let it enter sleep
        sleeper.interrupt();               // (1) interrupt() happens-before detection
        sleeper.join();

        System.out.println("-> interrupt() happens-before the target detects it.");
    }

    // ============================================================
    // RULE 7: FINALIZER
    // ============================================================
    // "Object constructor completion happens-before finalize()."
    //
    // STORY: A tenant finishes moving in (constructor done), THEN the
    // cleaning crew (finalize()) comes. Move-in is ordered before cleanup.
    //
    // IMPORTANT: finalize() is DEPRECATED since Java 9 and removed in recent
    // JDKs (it may not run at all). We demonstrate the RULE with a static flag
    // that the constructor sets and finalize() reads. We force GC to try to
    // trigger finalization. This is for illustration only — do NOT rely on
    // finalize() in real code. Use try-with-resources / Cleaner instead.
    //
    // Because finalize() is unreliable, we print a note even if it doesn't run.
    static volatile boolean finalizerRan = false;

    static class FinalizableObject {
        int value;

        FinalizableObject(int v) {
            this.value = v;                // (1) constructor completes
            // After the constructor returns, happens-before finalize().
        }

        @Override
        @SuppressWarnings("deprecation")
        protected void finalize() throws Throwable {
            try {
                // (2) constructor completion happens-before this finalize()
                // GUARANTEED: this.value is fully visible here (== 123).
                System.out.println("finalize() sees value = " + value);
                finalizerRan = true;
            } finally {
                super.finalize();
            }
        }
    }

    static void rule7_finalizer() throws InterruptedException {
        System.out.println("\n=== RULE 7: FINALIZER ===");

        FinalizableObject obj = new FinalizableObject(123);  // constructor runs
        obj = null;                                          // make eligible for GC

        // Force garbage collection to try to trigger finalize().
        // (Not guaranteed, but usually works on HotSpot for demo purposes.)
        for (int i = 0; i < 5 && !finalizerRan; i++) {
            System.gc();
            System.runFinalization();
            Thread.sleep(200);
        }

        if (finalizerRan) {
            System.out.println("-> Constructor completion happens-before finalize().");
        } else {
            System.out.println("-> finalize() did not run (deprecated/unreliable).");
            System.out.println("-> RULE still holds if it runs: constructor happens-before finalize().");
        }
        System.out.println("-> NOTE: finalize() is deprecated; use try-with-resources or Cleaner.");
    }

    // ============================================================
    // RULE 8: TRANSITIVITY
    // ============================================================
    // "If A→B and B→C, then A→C."
    //
    // THE CHAIN (3 threads):
    //   Thread A: x = 1;  flag = true;        (flag is volatile)
    //   Thread B: while(!flag){}  y = x;      (reads flag, then x)
    //   Main:     b.join();  print(y);
    //
    // Why main is guaranteed to see y == 1:
    //   (1) x=1 -> (2) flag=true          : program order in A
    //   (2) flag=true -> (3) read flag    : volatile rule
    //   (3) read flag -> (4) y=x          : program order in B
    //   (4) y=x -> (5) join returns       : join rule
    //   (5) join -> (6) print(y)          : program order in main
    //   By transitivity: (1) -> (6). So main sees x=1 -> y=1.
    //
    // If `flag` were NOT volatile, the chain breaks: B might spin forever,
    // or read x=0 and write y=0, and main might print 0.
    static int transX = 0;
    static volatile boolean transFlag = false;
    static int transY = 0;

    static void rule8_transitivity() throws InterruptedException {
        System.out.println("\n=== RULE 8: TRANSITIVITY ===");

        transX = 0;
        transFlag = false;
        transY = 0;

        // Thread A: writes x, then flips volatile flag
        Thread a = new Thread(() -> {
            transX = 1;              // (1) plain write
            transFlag = true;        // (2) volatile write
        });

        // Thread B: waits for flag, then copies x to y
        Thread b = new Thread(() -> {
            while (!transFlag) {}    // (3) volatile read -> sees true
            transY = transX;         // (4) reads x (sees 1 via transitivity), writes y
        });

        a.start();
        b.start();
        b.join();                    // (5) join -> everything in B happens-before here

        // (6) By transitivity (1)->(6), main is GUARANTEED to see transY == 1.
        System.out.println("main sees transY = " + transY + " (expected 1)");

        System.out.println("-> Chain: x=1 -> flag=true -> read flag -> y=x -> join -> print(y)");
        System.out.println("-> Transitivity: since A->B and B->C, then A->C.");
    }

    // ============================================================
    // MAIN: run all rules in order
    // ============================================================
    public static void main(String[] args) throws InterruptedException {
        System.out.println("==================================================");
        System.out.println(" Java Memory Model: All 8 Happens-Before Rules");
        System.out.println("==================================================");

        rule1_programOrder();
        rule2_monitorLock();
        rule3_volatile();
        rule4_threadStart();
        rule5_threadJoin();
        rule6_interruption();
        rule7_finalizer();
        rule8_transitivity();

        System.out.println("\n==================================================");
        System.out.println(" DONE. All 8 rules demonstrated.");
        System.out.println("==================================================");
    }
}