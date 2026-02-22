package dsa.weekly_contest;

/*
    Problem: 3847. Find the Score Difference in a Game

    You are given an integer array nums,
    where nums[i] represents the points scored in the i-th game.

    There are exactly two players:
    - Player 1 (initially ACTIVE)
    - Player 2 (initially INACTIVE)

    Rules applied sequentially for each game index i:

    1) If nums[i] is odd:
       - Swap the roles of active and inactive players.

    2) In every 6th game (i.e., when i == 5, 11, 17, ...):
       - Swap the roles of active and inactive players.
       - This means (i + 1) % 6 == 0

    3) After applying the above swaps (if any),
       - The ACTIVE player gains nums[i] points.

    Finally:
    Return the score difference:
        (Player1 total score - Player2 total score)
*/
public class FindTheScoreDifferenceInGame {
    public int scoreDifference(int[] nums) {
        int n = nums.length;
        int playerOne = 0, playerTwo = 0;
        boolean isFirst = true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num % 2 == 1) {
                isFirst = !isFirst;
            }
            if (i % 6 == 5) {
                isFirst = !isFirst;
            }
            if (isFirst) {
                playerOne += num;
            } else {
                playerTwo += num;
            }
        }
        return playerOne - playerTwo;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
    }
}
