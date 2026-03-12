package dsa.string;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(new PermutationInString().checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Freq = new int[26];
        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        int[] s2Freq = new int[26];
        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            s2Freq[s2.charAt(right) - 'a']++;
            if (right - left + 1 > s1.length()) {
                s2Freq[s2.charAt(left) - 'a']--;
                left++;
            }
            if (matches(s1Freq, s2Freq)) {
                return true;
            }
        }
        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
