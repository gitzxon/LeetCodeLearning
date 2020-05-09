package study.stringtodouble;

public class Solution {
    public static void main(String[] args) {
        String s = "";

        System.out.println("s = " + convert("-2"));;

    }

    public static double convert(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("s is null or empty");
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(c >= '0' && c <= '9' || c == '.' || c == '-')) {
                throw new IllegalArgumentException("invalid char at : " + i);
            }
        }

        char head = s.charAt(0);
        if (head == '0') {
            if (s.length() > 1) {
                if (s.charAt(1) != '.') {
                    throw new IllegalArgumentException("invalid char at : 1");
                } else if (s.length() == 2) {
                    throw new IllegalArgumentException("invalid input for 0.");
                }
            }
        }

        // todo : pre check

        int dot = s.indexOf('.');
        int lengthForPre = 0;
        if (dot == -1) {
            lengthForPre = s.length();
        } else {
            lengthForPre = dot;
        }

        if (s.charAt(0) == '-') {
            lengthForPre -= 1;
        }


        double cur = 1;
        for (int i = 0; i < lengthForPre - 1; i++) {
            cur = cur * 10;
        }

        double result = 0;
        boolean negative = false;
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (c == '.') {
                continue;
            }
            if (c == '-') {
                negative = true;
                continue;
            }
            int value = c - '0';
            result = result + value * cur;
            cur = cur / 10;
        }

        if (negative) {
            return -1 * result;
        } else {
            return result;
        }
    }

}
