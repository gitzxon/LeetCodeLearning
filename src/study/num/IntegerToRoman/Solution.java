package study.num.IntegerToRoman;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String intToRoman(int num) {

        int cur = num;

        List<Integer> keys = new ArrayList<>();
        keys.add(1);
        keys.add(4);
        keys.add(5);
        keys.add(9);
        keys.add(10);
        keys.add(40);
        keys.add(50);
        keys.add(90);
        keys.add(100);
        keys.add(400);
        keys.add(500);
        keys.add(900);
        keys.add(1000);

        List<String> values = new ArrayList<>();
        values.add("I");
        values.add("IV");
        values.add("V");
        values.add("IX");
        values.add("X");
        values.add("XL");
        values.add("L");
        values.add("XC");
        values.add("C");
        values.add("CD");
        values.add("D");
        values.add("CM");
        values.add("M");

        StringBuilder stringBuilder = new StringBuilder();
        while (cur != 0) {

            int key = -1;
            String value = "";
            for (int i = keys.size() - 1; i >= 0; i--) {
                if (keys.get(i) <= cur) {
                    key = keys.get(i);
                    value = values.get(i);
                    break;
                }
            }
            cur -= key;
            stringBuilder.append(value);
        }
        return stringBuilder.toString();
    }
}