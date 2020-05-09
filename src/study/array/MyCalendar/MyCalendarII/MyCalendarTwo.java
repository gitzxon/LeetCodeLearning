package study.array.MyCalendar.MyCalendarII;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo {

    List<int[]> books = new ArrayList<>();
    public MyCalendarTwo() {
    }

    public boolean book(int start, int end) {

        MyCalendarOne myCalendarOne = new MyCalendarOne();

        for (int[] book : books) {
            int iteStart = book[0];
            int iteEnd = book[1];
            if (Math.max(iteStart, start) < Math.min(iteEnd, end)) {
                if (!myCalendarOne.book(Math.max(iteStart, start) , Math.min(iteEnd, end))) {
                    return false;
                }
            }
        }

        int[] book = new int[2];
        book[0] = start;
        book[1] = end;
        books.add(book);
        return true;
    }


    private static class MyCalendarOne {

        private List<int[]> books = new ArrayList<>();

        public boolean book(int start, int end) {
            for (int[] ints : books) {
                int iteStart = ints[0];
                int iteEnd = ints[1];
                if (Math.max(iteStart, start) < Math.min(iteEnd, end)) {
                    return false;
                }
            }
            int[] book = new int[2];
            book[0] = start;
            book[1] = end;
            books.add(book);
            return true;
        }
    }
}
