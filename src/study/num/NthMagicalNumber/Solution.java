package study.num.NthMagicalNumber;

class Solution {

    public int nthMagicalNumber(int n, int num1, int num2) {
        int a = num1;
        int b = num2;
        while (a % b != 0) {
            int remain = a % b;
            a = b;
            b = remain;
        }
        int gcd = b;
        int lcm = num1 * num2 / gcd;

        long left = 1;
        long right = (long) 1e14;

        long result = -1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = mid / num1 + mid / num2 - mid / lcm;
            if (count == n) {
                if (mid % num1 == 0 || mid % num2 == 0) {
                    result = mid;
                    break;
                } else {
                    right = mid - 1;
                }
            } else if (count < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                if (right < left) {
                    result = right;
                    break;
                }
            }
        }


        long mod = (long) (1e9 + 7);
        return (int) (result % mod);
    }

}
