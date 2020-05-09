package study.array.MaxConsecutiveOnesIII;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * a slow version.
 */
class Solution {
    public int longestOnes(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        List<List<Integer>> contiguousOnes = new ArrayList<>();
        generateContiguousOnes(nums, contiguousOnes);

//        for (int i = 0; i < contiguousOnes.size(); i++) {
//            int start = contiguousOnes.get(i).get(0);
//            int end = contiguousOnes.get(i).get(1);
//            System.out.println("start = " + start);
//            System.out.println("end = " + end);
//        }

        Deque<Integer> queueForK = new LinkedList<>();
        Deque<List<Integer>> queueForPair = new LinkedList<>();


        int max = 0;
        int remainK = k;
        int idx = 0;
        while (idx < contiguousOnes.size()) {
            List<Integer> curPair = contiguousOnes.get(idx);
            if (queueForPair.isEmpty()) {
                queueForPair.add(curPair);
                max = Math.max(max, curPair.get(1) - curPair.get(0) + 1 + remainK);
                if (max > nums.length) {
                    max = nums.length;
                }
                idx += 1;
            } else {
                List<Integer> lastPair = queueForPair.getLast();
                int delta = curPair.get(0) - lastPair.get(1) - 1;
                if (delta <= remainK) {
                    queueForPair.addLast(curPair);
                    queueForK.addLast(delta);
                    remainK -= delta;
                    max = Math.max(max, curPair.get(1) - queueForPair.getFirst().get(0) + 1 + remainK);
                    if (max > nums.length) {
                        max = nums.length;
                    }
                    idx += 1;
                } else {
                    queueForPair.removeFirst();
                    if (!queueForK.isEmpty()) {
                        remainK += queueForK.removeFirst();
                    }
                }
            }
        }

        return max;
    }

    private void generateContiguousOnes(int[] nums, List<List<Integer>> contiguousOnes) {
        int start = 0;
        int i = 0;
        while (i >= 0 && i <= nums.length) {
            int pre;
            if (i == 0) {
                pre = 0;
            } else {
                pre = nums[i - 1];
            }

            int cur;
            if (i == nums.length) {
                cur = 0;
            } else {
                cur = nums[i];
            }

            if (cur == 1 && pre == 0) {
                start = i;
            }

            if (cur == 0 && pre == 1) {
                List<Integer> pair = new ArrayList<>(2);
                pair.add(start);
                pair.add(i - 1);
                contiguousOnes.add(pair);
            }

            i++;
        }
    }
}