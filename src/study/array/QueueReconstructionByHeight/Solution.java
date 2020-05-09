package study.array.QueueReconstructionByHeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] reconstructQueue(int[][] people) {

        if (people == null || people.length <= 1) return people;

        // sort by height, descending
        // for same height, sort by num, ascending
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        List<int[]> resultContainer = new ArrayList<>(people.length);
        for (int i = 0; i < people.length; i++) {
            resultContainer.add(people[i][1], people[i]);
        }

        int[][] result = new int[resultContainer.size()][2];
        for (int i = 0; i < resultContainer.size(); i++) {
            result[i] = resultContainer.get(i);
        }
        return result;
    }
}