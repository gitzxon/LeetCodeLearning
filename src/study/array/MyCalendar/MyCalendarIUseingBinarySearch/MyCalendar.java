package study.array.MyCalendar.MyCalendarIUseingBinarySearch;

import java.util.TreeMap;

/*
 * @lc app=leetcode id=729 lang=java
 *
 * [729] My MyCalendar I
 */
public class MyCalendar {

    private TreeMap<Integer, Integer> map = new TreeMap<>(); // start -> end

    public boolean book(int start, int end) {

        Integer floorKey = map.floorKey(start);
        if (floorKey != null && map.get(floorKey) > start) {
            return false;
        }

        Integer ceilingKey = map.ceilingKey(start);
        if (ceilingKey != null && ceilingKey < end) {
            return false;
        }

        map.put(start, end);
        return true;
    }

}

/**
 * Your MyCalendar object will be instantiated and called as such: MyCalendar
 * obj = new MyCalendar(); boolean param_1 = obj.book(start,end);
 */
