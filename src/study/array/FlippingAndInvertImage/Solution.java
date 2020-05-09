package study.array.FlippingAndInvertImage;

class Solution {
    public int[][] flipAndInvertImage(int[][] pixels) {

        if (pixels == null || pixels.length == 0) {
            return pixels;
        }

        int rowCount = pixels.length;
        int colCount = pixels[0].length;
        int half = colCount / 2;

        if (colCount % 2 != 0) {
            for (int i = 0; i < rowCount; i++) {
                pixels[i][half] = invert(pixels[i][half]);
            }
        }

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < half; j++) {
                pixels[i][j] = invert(pixels[i][j]);
                int tail = colCount - j - 1;
                pixels[i][tail] = invert(pixels[i][tail]);
                int swap = pixels[i][j];
                pixels[i][j] = pixels[i][tail];
                pixels[i][tail] = swap;
            }
        }
        return pixels;
    }

    public int invert(int a) {
        if (a == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}