package misc.MaxPointsOnALine;

import misc.Point;

import java.util.*;

/**
 * 此题目在做的时候，引起了极大的心理和生理上的不适，等有时间回头再看看吧。
 */
class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        // Point to PointWrapper
        PointWrapper[] pointWrappers = new PointWrapper[points.length];
        for (int i = 0; i < points.length; i++) {
            pointWrappers[i] = new PointWrapper(points[i]);
        }

        // count PointWrapper
        HashMap<PointWrapper, Integer> pointerWrapperToCountHashMap = new HashMap<>();
        for (PointWrapper pointWrapper : pointWrappers) {
            pointerWrapperToCountHashMap.put(pointWrapper, pointerWrapperToCountHashMap.getOrDefault(pointWrapper, 0) + 1);
        }

        // unique PointWrapper
        List<PointWrapper> uniquePointWrapperList = new ArrayList<>(pointerWrapperToCountHashMap.keySet().size());
        for (PointWrapper pointWrapper : pointerWrapperToCountHashMap.keySet()) {
            uniquePointWrapperList.add(pointWrapper);
        }

//        System.out.println("uniquePointWrapperList = " + uniquePointWrapperList);

        HashMap<Line, HashSet<PointWrapper>> lineToPointsHashMap = new HashMap<>();
        outer:
        for (int i = 0; i < uniquePointWrapperList.size(); i++) {

            PointWrapper p1 = uniquePointWrapperList.get(i);

            inner:
            for (int j = i; j < uniquePointWrapperList.size(); j++) {
                if (j == i) {
                    continue;
                }

                PointWrapper p2 = uniquePointWrapperList.get(j);
                Line line = getLine(p1, p2);

                HashSet<PointWrapper> set;
                if (lineToPointsHashMap.containsKey(line)) {
                    set = lineToPointsHashMap.get(line);
                } else {
                    set = new HashSet<>();
                }
//                System.out.println("p1 = " + p1);
//                System.out.println("p2 = " + p2);
//                System.out.println("line = " + line);
//                System.out.println("set.size() = " + set.size());

                set.add(p1);
                set.add(p2);
                lineToPointsHashMap.put(line, set);
            }
        }

        int max = 1;
        for (Map.Entry<Line, HashSet<PointWrapper>> entry : lineToPointsHashMap.entrySet()) {
            int count = entry.getValue().size();
            for (PointWrapper pointWrapper : entry.getValue()) {
                if (pointerWrapperToCountHashMap.containsKey(pointWrapper)) {
                    count = count - 1 + pointerWrapperToCountHashMap.get(pointWrapper);
                }
            }
            if (count > max) {
                max = count;
            }
        }

        for (Integer integer : pointerWrapperToCountHashMap.values()) {
            if (integer > max) {
                max = integer;
            }
        }

        return max;

    }

    boolean isOnLine(Line line, PointWrapper pointWrapper) {
        return isOnLine(line, pointWrapper.x, pointWrapper.y);
    }

    boolean isOnLine(Line line, int x, int y) {
        if (line.vertical) {
            return line.b == x;
        } else {
            return x * line.k + line.b == y;
        }
    }


    Line getLine(PointWrapper point1, PointWrapper point2) {

        if (point1.x == point2.x && point1.y == point2.y) {
            return null;
        }

        if (point1.x == point2.x) {
            return new Line(point1.x);
        } else if (point1.y == point2.y) {
            return new Line(0, point1.y);
        } else {
            int k = (point1.y - point2.y) / (point1.x - point2.x);
            int b = point1.y - k * point1.x;
            return new Line(k, b);
        }
    }

    public class Line {
        int k;
        int b;
        boolean vertical = false;

        public Line(int k, int b) {
            this.k = k;
            this.b = b;
        }

        public Line(int b) {
            vertical = true;
            this.b = b;
        }

        @Override
        public boolean equals(Object obj) {

            if (obj == null) return false;

            if (!(obj instanceof Line)) {
                return false;
            }

            Line that = (Line) obj;
            if (that.vertical && this.vertical) {
                return this.b == that.b;
            } else if (this.vertical || that.vertical) {
                return false;
            } else {
                return this.k == that.k
                        && this.b == that.b;
            }
        }

        @Override
        public int hashCode() {
            return k & b;
//            return toString().hashCode();

        }

        @Override
        public String toString() {
            if (vertical) {
                return "k: @@" + " b : " + b;
            }
            return "k: " + k + " b : " + b;
        }
    }

    public static class PointWrapper {
        int x;
        int y;

        public PointWrapper(Point point) {
            this.x = point.x;
            this.y = point.y;
        }

        @Override
        public int hashCode() {
            return x & y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }

            if (obj instanceof PointWrapper) {
                return ((PointWrapper) obj).x == x && ((PointWrapper) obj).y == y;
            }
            return false;
        }

        @Override
        public String toString() {
            return "( " + x + ", " + y + " )";
        }
    }
}