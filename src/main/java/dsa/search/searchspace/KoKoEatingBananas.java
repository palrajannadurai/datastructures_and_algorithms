package dsa.search.searchspace;

public class KoKoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile: piles) {
            high = Math.max(high, pile);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canEat(piles, mid, h)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canEat(int[] piles, int speed, int h) {
        int hours = 0;
        for (int p: piles) {
            hours += (p + speed - 1) / speed;
        }
        return hours <= h;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(new KoKoEatingBananas().minEatingSpeed(piles, h));
    }
}
