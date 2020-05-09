package study.ds.heap.TopKFrequentElements;

import java.util.*;
import java.util.function.BiConsumer;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return helper(map, k);
    }

    private List<Integer> helper(HashMap<Integer, Integer> map, int k) {
        PriorityQueue<Container> priorityQueue = new PriorityQueue<>(new Comparator<Container>() {
            @Override
            public int compare(Container o1, Container o2) {
                return o2.frequent - o1.frequent;
            }
        });

        map.forEach(new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer integer, Integer integer2) {
                priorityQueue.add(new Container(integer, integer2));
            }
        });

        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            result.add(priorityQueue.poll().num);
        }
        return result;
    }

    private static class Container {
        public int num;
        public int frequent;
        Container(int num, int frequent) {
            this.num = num;
            this.frequent = frequent;
        }
    }
}