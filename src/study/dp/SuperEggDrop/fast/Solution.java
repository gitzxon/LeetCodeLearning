package study.dp.SuperEggDrop.fast;

/**
 * 不用预先设定 row 0 和 col 0，因为默认的 int 的初始值 0 其实可以使用在这里
 * 然后不用全算完。算到 >= N 就可以。
 *
 */
class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for(int m = 1; m <= N; m++) {
            for(int k = 1; k <= K; k++) {
                dp[k][m] = dp[k - 1][m - 1] + dp[k][m - 1] + 1;
                if(dp[k][m] >= N) {
                    return m;
                }
            }
        }
        return N;
    }
}