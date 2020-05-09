package study.array.MyCalendar.MyCalanderI;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=729 lang=java
 *
 * [729] My MyCalendar I
 */
public class MyCalendar {

    List<Range> rangeList = new ArrayList<>();

    public MyCalendar() {
    }

    public boolean book(int start, int end) {

        for (int i = 0; i < rangeList.size(); i++) {
            if (overlap(start, end, rangeList.get(i).start, rangeList.get(i).end)) {
                return false;
            }
        }

        rangeList.add(new Range(start, end));
        return true;
    }

    private boolean overlap(int s1, int e1, int s2, int e2) {
        boolean notOverlap = Math.max(s1, s2) >= Math.min(e1, e2);
        return !notOverlap;
    }

    private static class Range {

        int start;
        int end;

        Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Range) {
                if (this.start == ((Range) obj).start && this.end == ((Range) obj).end) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(start) + Integer.hashCode(end);
        }

    }
}

/**
 * Your MyCalendar object will be instantiated and called as such: MyCalendar
 * obj = new MyCalendar(); boolean param_1 = obj.book(start,end);
 */
