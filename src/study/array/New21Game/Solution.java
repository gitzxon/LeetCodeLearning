package study.array.New21Game;

class Solution {


    public double new21Game(int N, int K, int W) {

        if (K == 0 || N >= K + W) return 1;

        double[] possibilities = new double[N + 1];
        possibilities[0] = 1;

        double slidingWindow = 1;
        int i = 1;
        while (i <= N) {

            possibilities[i] = slidingWindow / W;
            if (i < K) {
                slidingWindow += possibilities[i];
            }
            if (i - W >= 0) {
                slidingWindow -= possibilities[i - W];
            }

            i++;
        }

        int start = K;
        int end = N;
        double result = 0;
        for (int j = start; j <= end; j++) {
            result += possibilities[j];
        }

        return result;
    }
}