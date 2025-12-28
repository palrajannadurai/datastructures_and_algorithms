package dsa.slidingwindow;

public class LeetCode1456 {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int maxVowels(String s, int k) {
        int n = s.length();
        if (n < k) {
            return 0;
        }
        int left = 0;
        int currentLength = 0, maxLength = 0;
        for (int right = 0; right < n; right++) {
            if (isVowel(s.charAt(right))) {
                currentLength++;
            }
            if (right - left + 1 == k) {
                maxLength = Math.max(currentLength, maxLength);
                if (maxLength == k) {
                    return k;
                }
                if (isVowel(s.charAt(left))) {
                    currentLength--;
                }
                left++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        LeetCode1456 instanc = new LeetCode1456();
        System.out.println(instanc.maxVowels(s, k));
    }
}
