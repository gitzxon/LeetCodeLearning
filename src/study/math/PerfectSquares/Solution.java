package study.math.PerfectSquares;

import java.util.Arrays;

class Solution {

    /**
     *     // dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int j = 1;
            int baseIndex = i - j * j;
            while (baseIndex >= 0) {

                if (baseIndex == 0) {
                    dp[i] = 1;
                } else {
                    dp[i] = Math.min(
                            dp[i],
                            dp[baseIndex] + 1
                    );
                }

                j += 1;
                baseIndex = i - j * j;
            }
        }
        return dp[n];
    }


}
