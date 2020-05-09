package study.num.FractionToRecuringDecimal;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = numerator;
        long denominatorLong = denominator;
        if (numeratorLong * denominatorLong < 0) {
            return "-" + fractionToDecimalHelper(Math.abs(numeratorLong), Math.abs(denominatorLong));
        }
        return fractionToDecimalHelper(Math.abs(numeratorLong), Math.abs(denominatorLong));
    }


    private String fractionToDecimalHelper(long numerator, long denominator) {

        long currentNum = numerator;
        long integerPart;
        if (currentNum >= denominator) {
            integerPart = (currentNum - currentNum % denominator) / denominator;
        } else {
            integerPart = 0;
        }

        currentNum = currentNum - denominator * integerPart;
        if (currentNum == 0) {
            return String.valueOf(integerPart);
        }

        ArrayList<Long> list = new ArrayList<>();
        HashMap<Long, Integer> remainToIndexMap = new HashMap<>();
        boolean infinite = false;
        int infiniteStartIndex = -1;
        remainToIndexMap.put(currentNum, 0);

        while (true) {
            currentNum *= 10;
            if (remainToIndexMap.containsKey(currentNum)) {
                infinite = true;
                infiniteStartIndex = remainToIndexMap.get(currentNum);
                break;
            } else {
                remainToIndexMap.put(currentNum, list.size());
            }
            if (currentNum < denominator) {
                list.add(0L);
                continue;
            }
            long remain = currentNum % denominator;
            long divideResult = (currentNum - remain) / denominator;

            list.add(divideResult);
            if (remain == 0) {
                break;
            }
            currentNum = remain;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(integerPart);
        stringBuilder.append(".");
        if (!infinite) {
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append(list.get(i));
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (i == infiniteStartIndex) {
                    stringBuilder.append("(");
                }
                stringBuilder.append(list.get(i));
            }
            stringBuilder.append(")");
        }

        return stringBuilder.toString();
    }


}