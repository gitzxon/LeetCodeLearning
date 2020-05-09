package study.array.LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return "";
        }

        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(string);
        }

        String result = stringBuilder.toString();
        if (result.charAt(0) == '0') {
            return "0";
        }

        return result;
    }
}