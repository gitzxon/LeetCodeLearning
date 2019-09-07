package array.SlidingWindowMedian;

import java.util.*;

/**
 * 30 / 42 test cases passed.
 * Status: Time Limit Exceeded
 */
class Solution {

    // (a,b)->(b-a) 如果 a 和 b 取到 Integer.MAXVALUE 的时候，就会出问题。
    TreeMap<Integer, Integer> smallMap = new TreeMap<>(Comparator.reverseOrder());
    TreeMap<Integer, Integer> bigMap = new TreeMap<>(Comparator.comparingInt(o -> o));

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new double[0];
        }

        int idx = 0;
        while (idx < k) {
            addOneIntoMap(bigMap, nums[idx]);
            idx++;
            divideNumsIntoTwoMap();
        }
        List<Double> result = new ArrayList<>();
        result.add(getMedian());

        while (idx <= nums.length - 1) {
            int num = nums[idx];
            int numToRemove = nums[idx - k];
            idx++;
            addOneIntoMap(bigMap, num);
            if (bigMap.containsKey(numToRemove)) {
                removeOneFromMap(bigMap, numToRemove);
            } else {
                removeOneFromMap(smallMap, numToRemove);
            }

            divideNumsIntoTwoMap();
            result.add(getMedian());
        }

        double[] resultArray = new double[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    private void divideNumsIntoTwoMap() {
        if (getSize(bigMap) - getSize(smallMap) >= 2) {
            Map.Entry<Integer, Integer> entry = bigMap.firstEntry();

            if (entry.getValue() == 1) {
                bigMap.remove(entry.getKey());
            } else {
                bigMap.put(entry.getKey(), entry.getValue() - 1);
            }

            smallMap.put(entry.getKey(), smallMap.getOrDefault(entry.getKey(), 0) + 1);
        }
        if (!bigMap.isEmpty() && !smallMap.isEmpty() && bigMap.firstEntry().getKey() < smallMap.firstEntry().getKey()) {
            Map.Entry<Integer, Integer> bigEntry = bigMap.firstEntry();
            Map.Entry<Integer, Integer> smallEntry = smallMap.firstEntry();

            removeOneFromMap(bigMap, bigEntry.getKey());
            removeOneFromMap(smallMap, smallEntry.getKey());

            addOneIntoMap(bigMap, smallEntry.getKey());
            addOneIntoMap(smallMap, bigEntry.getKey());
        }
    }

    private void removeOneFromMap(Map<Integer, Integer> map, Integer key) {
        Integer value = map.getOrDefault(key, 0);
        if (value <= 1) {
            map.remove(key);
        } else {
            map.put(key, value - 1);
        }
    }

    private void addOneIntoMap(Map<Integer, Integer> map, Integer key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    private double getMedian() {
        if (bigMap.isEmpty() && smallMap.isEmpty()) {
            return 0;
        } else if (bigMap.isEmpty()) {
            return smallMap.firstEntry().getKey();
        } else if (smallMap.isEmpty()) {
            return bigMap.firstEntry().getKey();
        }

        if (getSize(bigMap) == getSize(smallMap)) {
            Double big = Double.valueOf(bigMap.firstKey());
            Double small = Double.valueOf(smallMap.firstKey());
            return (big + small) / 2;
        } else {
            return bigMap.firstKey();
        }
    }

    private int getSize(Map<Integer, Integer> map) {
        int count = 0;
        for (Integer integer : map.keySet()) {
            count += map.get(integer);
        }
        return count;
    }
}