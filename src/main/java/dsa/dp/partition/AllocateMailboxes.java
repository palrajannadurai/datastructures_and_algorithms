package dsa.dp.partition;

import java.util.Arrays;

/**
 * வீடுகளை k குழுக்களாகப் பிரித்து, ஒவ்வொரு குழுவிற்கும் அஞ்சல் பெட்டியை
 * அந்த குழுவின் median (நடுநிலை) இடத்தில் வைத்து,
 * அனைத்து வீடுகளிலிருந்தும் அவற்றின் அஞ்சல் பெட்டிக்கான தூரங்களின்
 * கூட்டுத்தொகையைக் குறைக்கும் குறைந்தபட்ச மதிப்பைக் கணக்கிடும்.
 * <p>
 * Partition DP (பகிர்வு டைனமிக் நிரலாக்கம்) முறையைப் பயன்படுத்துகிறது.
 * <p>
 * Recurrence Relation:
 * dp[i][k] = min( cost(i, j) + dp[j+1][k-1] ) for all j from i to n-1
 * <p>
 * இங்கு cost(i, j) என்பது i முதல் j வரையிலான வீடுகளை ஒரே குழுவாக எடுத்துக்
 * கொண்டு, அந்த குழுவின் median-க்கான மொத்த தூரக் கூட்டுத்தொகையாகும்.
 */
public class AllocateMailboxes {

    int[] houses;
    int n;
    int[][] dp;

    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        this.houses = houses;
        this.n = houses.length;
        this.dp = new int[n][k + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return solve(0, k);
    }

    /**
     * i-ஆம் இடத்திலிருந்து தொடங்கி k mailboxes உடன் கிடைக்கும் குறைந்தபட்ச தூரத்தைக் கணக்கிடும்
     * மறுநிகழ்வு (recursive) முறை
     *
     * @param i தற்போதைய தொடக்கக் குறியீடு (index)
     * @param k இன்னும் ஒதுக்கப்பட வேண்டிய அஞ்சல் பெட்டிகளின் எண்ணிக்கை
     * @return  குறைந்தபட்ச மொத்த தூரம்
     */
    int solve(int i, int k) {
        if (i == this.n && k == 0) return 0;
        if (i == n || k == 0) return Integer.MAX_VALUE;
        if (dp[i][k] != -1) return dp[i][k];
        int ans = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            int currentCost = cost(i, j);
            int next = solve(j + 1, k - 1);
            if (next != Integer.MAX_VALUE) {
                ans = Math.min(ans, currentCost + next);
            }
        }
        return dp[i][k] = ans;
    }

    /**
     * i முதல் j வரையிலான வீடுகளை ஒரே குழுவாக எடுத்துக் கொண்டால்,
     * அந்த குழுவிற்கு median (நடுநிலை) இடத்தில் அஞ்சல் பெட்டியை வைப்பதன்
     * மூலம் கிடைக்கும் மொத்த தூரக் கூட்டுத்தொகையைக் கணக்கிடுகிறது.
     * <p>
     * median-ஐ mailbox-ஆகப் பயன்படுத்துவதே குறைந்தபட்ச தூரத்தைத் தருகிறது.
     */
    int cost(int i, int j) {
        int m = (i + j) / 2;
        int total = 0;
        for (int x = i; x <= j; x++) {
            total += Math.abs(houses[x] - houses[m]);
        }
        return total;
    }

    public static void main(String[] args) {
        int[] houses = {1, 4, 8, 10, 20};
        int k = 3;
        System.out.println(new AllocateMailboxes().minDistance(houses, k));
    }
}
