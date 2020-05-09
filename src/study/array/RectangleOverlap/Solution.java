package study.array.RectangleOverlap;

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        if (rec1 == null || rec1.length == 0
                || rec2 == null || rec2.length == 0) {
            return false;
        }

        if (rec1[0] > rec2[0]) {
            return isRectangleOverlap(rec2, rec1);
        }

        int width1 = getRight(rec1) - getLeft(rec1);
        if (getLeft(rec2) - getLeft(rec1) >= width1) {
            return false;
        }

        int height1 = getBottom(rec1) - getTop(rec1);
        int height2 = getBottom(rec2) - getTop(rec2);
        if (getTop(rec2) < getTop(rec1)) {
            if (getTop(rec1) - getTop(rec2) >= height2) {
                return false;
            }
        } else if (getTop(rec2) == getTop(rec1)
                && (height1 == 0 || height2 == 0)){
            return false;
        } else {
            if (getTop(rec2) - getTop(rec1) >= height1) {
                return false;
            }
        }

        return true;
    }

    private int getLeft(int[] rec) {
        return rec[0];
    }
    private int getTop(int[] rec) {
        return rec[1];
    }
    private int getRight(int[] rec) {
        return rec[2];
    }
    private int getBottom(int[] rec) {
        return rec[3];
    }



}