package study.graph.CourseSchedule.I;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) {
            return true;
        }

        int rowCount = prerequisites.length;
        if (rowCount == 0) {
            return true;
        }

        HashMap<Integer, HashSet<Integer>> dependencyMap = new HashMap<>();
        for (int i = 0; i < rowCount; i++) {
            int start = prerequisites[i][0];
            int end = prerequisites[i][1];

            HashSet<Integer> set = dependencyMap.getOrDefault(end, new HashSet<>());
            set.add(start);
            dependencyMap.put(end, set);
        }

        int[] preCount = new int[numCourses];
        for (int i = 0; i < preCount.length; i++) {
            preCount[i] = 0;
        }
        for (Integer key : dependencyMap.keySet()) {
            HashSet<Integer> set = dependencyMap.get(key);
            for (Integer integer : set) {
                preCount[integer] += 1;
            }
        }

        int remainingCount = numCourses;
        boolean canFinish = true;

        outter:
        while (remainingCount != 0) {

            inner:
            for (int i = 0; i < preCount.length; i++) {
                if (preCount[i] == 0) {
                    System.out.println("i = " + i);
                    HashSet<Integer> set = dependencyMap.getOrDefault(i, new HashSet<>());

                    for (Integer integer : set) {
                        preCount[integer] -= 1;
                    }
                    dependencyMap.remove(i);
                    remainingCount -= 1;
                    preCount[i] = -1;
                    continue outter;
                }
            }

            if (remainingCount != 0) {
                canFinish = false;
                break;
            }
        }

        return canFinish;
    }
}