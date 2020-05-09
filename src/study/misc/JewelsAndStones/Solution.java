package study.misc.JewelsAndStones;

import java.util.HashSet;

class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> jewels = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            char c = J.charAt(i);
            jewels.add(c);
        }

        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (jewels.contains(c)) {
                count ++;
            }
        }
        return count;
    }
}