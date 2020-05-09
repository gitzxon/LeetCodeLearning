package study.misc.CountNumbersWithUniqueDigits;

class Solution {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        if (n == 2) return 91;
        if (n > 10) return countNumbersWithUniqueDigits(10);

        if (n == 10) {
            return countNumbersWithUniqueDigits(n - 1) + 9 * permutation(9, 9);
        } else {
            return countNumbersWithUniqueDigits(n - 1) + permutation(9, n) + permutation(9, n - 1) * (n - 1);
        }

    }

    public int permutation(int total, int pick) {

        if (pick > total) {
            throw new IllegalArgumentException("pick > total");
        }

        int result = 1;
        for (int i = 0; i < pick; i++) {
            result *= (total - i);
        }
        return result;
    }
}