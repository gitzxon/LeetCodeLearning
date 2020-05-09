package study.graph.CourseSchedule.II;

import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        if (numCourses == 1) {
            int[] result = new int[1];
            result[0] = 0;
            return result;
        }

        int[] indegree = new int[numCourses];

        HashMap<Integer, HashSet<Integer>> courseToLearn = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][0];
            int end = prerequisites[i][1];
            HashSet<Integer> set = courseToLearn.getOrDefault(end, new HashSet<>());
            set.add(start);
            courseToLearn.put(end, set);
            indegree[start] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        addCourseToQueueIfReady(indegree, queue);

        List<Integer> resultList = new ArrayList<>(numCourses);
        while (queue.size() != 0) {

            int ready = queue.poll();
            HashSet<Integer> set = courseToLearn.getOrDefault(ready, new HashSet<>());
            for (Integer integer : set) {
                indegree[integer] -= 1;
            }
            courseToLearn.remove(ready);
            resultList.add(ready);
            addCourseToQueueIfReady(indegree, queue);
        }

        if (courseToLearn.keySet().size() != 0) {
            return new int[0];
        }

        return unpack(resultList);
    }

    private void addCourseToQueueIfReady(int[] indegree, Queue<Integer> queue) {
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                indegree[i] = -1;
            }
        }
    }

    private int[] unpack(List<Integer> list){
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}