package study.array.LongestMountainInArray;

class Solution {
    public int longestMountain(int[] A) {
        int len = 0, up = 0, down = 0;
        for (int i = 1; i < A.length; ++i) {
            if (down > 0 && A[i - 1] < A[i] || A[i - 1] == A[i]) up = down = 0;
            if (A[i - 1] < A[i]) up++;
            if (A[i - 1] > A[i]) down++;
            if (up > 0 && down > 0 && up + down + 1 > len) len = up + down + 1;
        }
        return len;
    }
}