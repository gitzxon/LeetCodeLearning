package study.string.ReverseWords;

public class Solution {

    public String reverseWords(String s) {
        s = s.trim().replaceAll(" +", " ");
        char[] charArray = s.toCharArray();
        reverse(charArray, 0,  charArray.length);

        int start = 0;
        int end = 1;
        while (end <= charArray.length) {
            if (end == charArray.length || charArray[end] == ' ' ) {
                reverse(charArray, start, end);
                start = end + 1;
                end = start + 1;
            } else {
                end = end + 1;
            }
        }
        return new String(charArray);
    }

    /**j
     * 左闭右开
     * @param charArray
     * @param startIndex
     * @param endIndex
     */
    private void reverse(char[] charArray, int startIndex, int endIndex) {

        int i = startIndex;
        int j = endIndex - 1;

        while (i < j) {
            swap(charArray, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] charArray, int a, int b) {
        char tmp = charArray[a];
        charArray[a] = charArray[b];
        charArray[b] = tmp;
    }
}