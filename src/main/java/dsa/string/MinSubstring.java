package dsa.string;

public class MinSubstring {

    private boolean hasAllCharacters(String s, int start, int end, int[] tFreq) {
        int[] sFreq = new int[128];
        for (int i = start; i <= end; i++) {
            sFreq[s.charAt(i)]++;
        }
        for (int i = 0; i < sFreq.length; i++) {
            if (tFreq[i] > sFreq[i]) {
                return false;
            }
        }
        return true;
    }

    public String minWindowBF(String s, String t) {
        if (s.length() < t.length()) return "";

        // Find the target Frequency
        int[] tFreq = new int[128];
        for (char sc : t.toCharArray()) {
            tFreq[sc]++;
        }

        String minWindow = "";
        int minLen = Integer.MAX_VALUE;
        for (int start = 0; start < s.length(); start++) {
            for (int end = start; end < s.length(); end++) {
                int len = end - start + 1;
                if (len < t.length()) {
                    continue;
                }
                if (hasAllCharacters(s, start, end, tFreq) && len < minLen) {
                    minWindow = s.substring(start, end + 1);
                    minLen = end - start + 1;
                    break;
                }
            }
        }
        return minWindow;
    }


    public String minWindow(String s, String t) {
        int[] tFreq = new int[128];
        for (int i = 0; i < t.length(); i++) {
            tFreq[t.charAt(i)]++;
        }

        int left = 0;
        int formed = 0;
        int required = t.length();
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int[] windowFreq = new int[128];
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(left);
            if (tFreq[c] > 0 && windowFreq[c] < tFreq[c]) {
                formed++;
            }
            windowFreq[c]++;
            if (formed == required) {
                System.out.println(s.substring(left, right));
            }
        }

        return null;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        System.out.println(new MinSubstring().minWindow("ADOBECODEBANC", "ABC"));
    }
}
