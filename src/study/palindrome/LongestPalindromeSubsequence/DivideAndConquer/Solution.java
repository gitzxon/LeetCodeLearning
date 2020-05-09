package study.palindrome.LongestPalindromeSubsequence.DivideAndConquer;

class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] mem = new int[s.length()][s.length()];
        return performDivideAndConquer(
                s, mem, 0, s.length() - 1
        );
    }

    private int performDivideAndConquer(
            String s,
            int[][] mem,
            int start,
            int end
    ) {
        if (start == end) {
            return 1;
        }

        if (start > end) {
            return 0;
        }

        if (mem[start][end] != 0) {
            return mem[start][end];
        }
        int result;
        if (s.charAt(start) == s.charAt(end)) {
            result = performDivideAndConquer(s, mem, start + 1, end - 1) + 2;
        } else {
            result = Math.max(
                    performDivideAndConquer(s, mem, start, end - 1),
                    performDivideAndConquer(s, mem, start + 1, end)
            );
        }

        mem[start][end] = result;
        return result;
    }
 }