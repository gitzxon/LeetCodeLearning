package study.dp.GasStation;

class Solution {
    /**
     * 其实不是 dp，是贪心。怎么才能很好的区分 dp 和贪心呢？
     * 贪心不是万能的，但是贪心能解决的问题一般用贪心效率都很高。
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int size = gas.length;

        int tmpCount = 0;
        for (int i = 0; i < size; i++) {
            tmpCount = tmpCount + gas[i] - cost[i];
        }
        if (tmpCount < 0) {
            return -1;
        }

        int[] gains = new int[size];
        for (int i = 0; i < gains.length; i++) {
            gains[i] = gas[i] - cost[i];
        }

        int start = 0;
        int sum = 0;
        for (int i = 0; i < gains.length; i++) {
            sum = sum + gains[i];
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }

        return start;
    }
}