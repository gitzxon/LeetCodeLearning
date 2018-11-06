package array.LongestMountainInArray;

public class SolutionNew {
    public int longestMountain(int[] A) {

        int result = 0;
        int up = 0;
        int down = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1] || down > 0 && A[i] > A[i - 1]) {
                up = 0;
                down = 0;
            }

            if (A[i] > A[i - 1]) up++;
            if (A[i] < A[i - 1]) down++;
            if (up > 0 && down > 0 && up + down + 1 > result) result = up + down + 1;

        }

        return result;

    }

}


