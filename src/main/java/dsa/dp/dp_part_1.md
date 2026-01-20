DYNAMIC PROGRAMMING MASTER NOTES (HUMAN / NUMAN THINKING)

--------------------------------------------------
HOW TO THINK IN DP
--------------------------------------------------
1. Decide what dp represents in simple words
2. Base case = smallest valid answer
3. Current answer is built using previous answers
4. Final dp value gives result

--------------------------------------------------
1) MAX PRODUCT SUBARRAY
--------------------------------------------------
Problem:
Find the maximum product of a contiguous subarray.

Human intuition:
Because negative * negative = positive, we must track:
- max product ending here
- min product ending here

If current number is negative, swap max and min.

State:
maxEnd = maximum product ending at index i
minEnd = minimum product ending at index i

Time: O(n)
Space: O(1)

Java Code:
class Solution {
public int maxProduct(int[] nums) {
int maxEnd = nums[0];
int minEnd = nums[0];
int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            if (curr < 0) {
                int temp = maxEnd;
                maxEnd = minEnd;
                minEnd = temp;
            }

            maxEnd = Math.max(curr, maxEnd * curr);
            minEnd = Math.min(curr, minEnd * curr);
            ans = Math.max(ans, maxEnd);
        }
        return ans;
    }
}

--------------------------------------------------
2) LONGEST INCREASING SUBSEQUENCE (LIS)
--------------------------------------------------
Problem:
Find the length of the longest strictly increasing subsequence.

Human intuition:
At every element, ask:
"How long is the increasing subsequence if I END here?"

State:
dp[i] = LIS ending exactly at index i

Transition:
For all j < i
if nums[j] < nums[i]
dp[i] = max(dp[i], dp[j] + 1)

Answer:
max(dp[i])

Time: O(n²)
Space: O(n)

Java Code:
class Solution {
public int lengthOfLIS(int[] nums) {
int n = nums.length;
int[] dp = new int[n];
int ans = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}

--------------------------------------------------
3) LONGEST COMMON SUBSEQUENCE (LCS)
--------------------------------------------------
Problem:
Find the longest subsequence common to two strings.

Human intuition:
Compare prefixes of both strings.
Choice: match characters or skip one.

State:
dp[i][j] = LCS length of first i chars of s1 and first j chars of s2

Transition:
If s1[i-1] == s2[j-1]
dp[i][j] = 1 + dp[i-1][j-1]
Else
dp[i][j] = max(dp[i-1][j], dp[i][j-1])

Time: O(m * n)
Space: O(m * n)

Java Code:
class Solution {
public int longestCommonSubsequence(String s1, String s2) {
int m = s1.length(), n = s2.length();
int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}

--------------------------------------------------
4) 0/1 KNAPSACK
--------------------------------------------------
Problem:
Maximize value with weight constraint.
Each item can be taken once or not taken.

Human intuition:
For every item, decide:
TAKE it or SKIP it.

State:
dp[i][w] = max value using first i items with capacity w

Transition:
If wt[i-1] <= w
dp[i][w] = max(
dp[i-1][w],
val[i-1] + dp[i-1][w - wt[i-1]]
)

Time: O(n * W)
Space: O(n * W)

Java Code:
class Solution {
public int knapSack(int W, int[] wt, int[] val, int n) {
int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        dp[i - 1][w],
                        val[i - 1] + dp[i - 1][w - wt[i - 1]]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][W];
    }
}

--------------------------------------------------
5) EDIT DISTANCE
--------------------------------------------------
Problem:
Convert word1 to word2 using insert, delete, replace.

Human intuition:
Try all 3 operations and choose minimum.

State:
dp[i][j] = min operations to convert first i chars to first j chars

Transition:
If chars match:
dp[i][j] = dp[i-1][j-1]
Else:
dp[i][j] = 1 + min(
dp[i-1][j],     // delete
dp[i][j-1],     // insert
dp[i-1][j-1]    // replace
)

Java Code:
class Solution {
public int minDistance(String word1, String word2) {
int m = word1.length(), n = word2.length();
int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j],
                        Math.min(dp[i][j - 1], dp[i - 1][j - 1])
                    );
                }
            }
        }
        return dp[m][n];
    }
}

--------------------------------------------------
6) MAXIMUM SUM INCREASING SUBSEQUENCE (MSIS)
--------------------------------------------------
Problem:
Find increasing subsequence with maximum sum.

Human intuition:
Same as LIS, but instead of length → sum.

State:
dp[i] = maximum sum of increasing subsequence ending at i

Transition:
If arr[j] < arr[i]
dp[i] = max(dp[i], dp[j] + arr[i])

Answer:
max(dp[i])

Java Code:
class Solution {
public int maxSumIS(int[] arr, int n) {
int[] dp = new int[n];
int ans = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}

--------------------------------------------------
7) MATRIX CHAIN MULTIPLICATION (MCM)
--------------------------------------------------
Problem:
Find minimum cost to multiply matrices.

Human intuition:
Choose best place to split the chain.

State:
dp[i][j] = minimum cost to multiply matrices from i to j

Transition:
dp[i][j] = min over k from i to j-1:
dp[i][k] + dp[k+1][j] + arr[i-1] * arr[k] * arr[j]

Java Code:
class Solution {
public int matrixMultiplication(int[] arr, int n) {
int[][] dp = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int i = 1; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j]
                             + arr[i - 1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[1][n - 1];
    }
}
