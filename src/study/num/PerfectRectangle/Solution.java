package study.num.PerfectRectangle;

import java.util.HashSet;

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {

        HashSet<Point> set = new HashSet<>();

        int area = 0;
        for (int[] rectangle : rectangles) {
            Point leftTop = getCornerTag(rectangle[0], rectangle[1]);
            Point rightTop = getCornerTag(rectangle[2], rectangle[1]);
            Point leftBottom = getCornerTag(rectangle[0], rectangle[3]);
            Point rightBottom = getCornerTag(rectangle[2], rectangle[3]);

            area += (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);

            if (!set.add(leftTop)) {
                set.remove(leftTop);
            }
            if (!set.add(rightTop)) {
                set.remove(rightTop);
            }
            if (!set.add(leftBottom)) {
                set.remove(leftBottom);
            }
            if (!set.add(rightBottom)) {
                set.remove(rightBottom);
            }
        }


        if (set.size() != 4) {
            return false;
        }

        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        for (Point point : set) {
            x1 = Math.min(x1, point.x);
            y1 = Math.min(y1, point.y);
            x2 = Math.max(x2, point.x);
            y2 = Math.max(y2, point.y);
        }
        int targetArea = (x2 - x1) * (y2 - y1);
        if (targetArea != area) {
            return false;
        }

        return true;
    }

    private Point getCornerTag(int x, int y) {
        return new Point(x, y);
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x + y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Point) {
                if (this.x == ((Point) obj).x && this.y == ((Point) obj).y) {
                    return true;
                }
            }
            return false;
        }
    }
}