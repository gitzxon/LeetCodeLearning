package study.array.FourSum.FourSumII;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map1 = getSumMap(A, B);
        HashMap<Integer, Integer> map2 = getSumMap(C, D);

        int result = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map2.entrySet()) {
            int sum = integerIntegerEntry.getKey();
            int count2 = integerIntegerEntry.getValue();
            int count1 = map1.getOrDefault(-sum, 0);
            result += count1 * count2;
        }
        return result;
    }


    public HashMap<Integer, Integer> getSumMap(int[] a, int[] b) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int sum = a[i] + b[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        return map;
    }
}