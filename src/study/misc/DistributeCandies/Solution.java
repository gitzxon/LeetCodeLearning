package study.misc.DistributeCandies;

import java.util.HashSet;

class Solution {
    public int distributeCandies(int[] candies) {

        HashSet<Integer> types = new HashSet<>();

        for (int i = 0; i < candies.length; i++) {
            types.add(candies[i]);
        }

        if (types.size() >= candies.length / 2) {
            return candies.length / 2;
        } else {
            return types.size();
        }
    }
}