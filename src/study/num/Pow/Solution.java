package study.num.Pow;

public class Solution {
    public double myPow(double x, int n) {
        System.out.println("n = " + n);
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1 / (x * myPow(x, -(n + 1)));
            }
            return 1 / myPow(x, (-1) * n);
        }

        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}