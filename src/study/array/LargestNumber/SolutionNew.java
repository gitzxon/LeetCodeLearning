package study.array.LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

public class SolutionNew {

    public String largestNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return "";
        }

        Integer[] integers = new Integer[nums.length];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = nums[i];
        }

        new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };

        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = "" + o1 + o2;
                String s2 = "" + o2 + o1;
                return s2.compareTo(s1);
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < integers.length; i++) {
            stringBuilder.append(integers[i]);
        }

        String result = stringBuilder.toString();
        if (result.charAt(0) == '0') {
            return "0";
        } else {
            return result;
        }

    }

}
