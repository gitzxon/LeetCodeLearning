package study.array.ShortestSubarrayWithSumAtLeastK;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;

/**
 * 不浪费时间了，学习一下大神的代码。
 * todo :
 */
class Solution {

    public int shortestSubarray(int[] A, int K) {
        return shortestSubarraySBVersion(A, K);
    }

    public int shortestSubarrayNBVersion(int[] A, int K) {
        int N = A.length;
        int res = N + 1;
        int[] B = new int[N + 1];
        for (int i = 0; i < N; i++) {
            B[i + 1] = B[i] + A[i];
        }

        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < N + 1; i++) {

            while (d.size() > 0 && B[i] - B[d.getFirst()] >= K) {
                res = Math.min(res, i - d.pollFirst());
            }

            while (d.size() > 0 && B[i] <= B[d.getLast()]) {
                d.pollLast();
            }

            d.addLast(i);
        }
        return res <= N ? res : -1;
    }

    public int shortestSubarraySBVersion(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        int currentLen = nums.length + 1;

        for (int i = 0; i < sums.length; i++) {
            treeMap.put(sums[i], i);

            int len = nums.length + 1;
            if (sums[i] >= k) {
                len = Math.min(len, i + 1);
            }

            int delta = sums[i] - k;
            Map.Entry<Integer, Integer> ceiling = treeMap.floorEntry(delta);

            if (ceiling != null) {
                if (sums[i] - ceiling.getKey() >= k) {
                    Map.Entry<Integer, Integer> entry = treeMap.firstEntry();
                    /**
                     * 加上这个遍历之后，感觉结果是对的，但是 tle 了。
                     * 需要减少此处的遍历次数。
                     * todo
                     * 添加一个 treeMap.remove 可以勉强通过了。
                     * 为甚么可以 remove ？
                     * 因为 i 是不断增长的，那么对于后续 i 而言，只有比这个 ceiling.getKey() 更大的 i，才有可能
                     * 成为 minLen。所以 ceiling 之前的可以都 remove 掉。
                     */
                    while (entry != null && entry.getKey() <= ceiling.getKey()) {
                        len = Math.min(len, i - entry.getValue());
                        treeMap.remove(entry.getKey());
                        entry = treeMap.higherEntry(entry.getKey());
                    }
                }
            }

            currentLen = Math.min(len, currentLen);
        }

        if (currentLen > nums.length) {
            return -1;
        } else {
            return currentLen;
        }
    }
}