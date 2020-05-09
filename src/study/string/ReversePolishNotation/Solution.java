package study.string.ReversePolishNotation;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public ArrayList<Object> generateReversePolishNotation(String s) {

        Stack<Character> s1 = new Stack<>();
        Stack<Object> result = new Stack();

        s1.push('#');
        int curNum = 0;
        boolean checkingNum = false;
        s = s + "#";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }

            if (Character.isDigit(c)) {
                curNum = curNum * 10 + (c - '0');
                checkingNum = true;
                if (i == s.length() - 1) {
                    result.push(curNum);
                }
            } else {
                if (checkingNum == true) {
                    checkingNum = false;
                    result.push(curNum);
                    curNum = 0;
                }

                Character curTop = s1.peek();
                if (c == '(') {
                    s1.push(c);
                } else if (c == ')') {
                    boolean foundRightBracket = false;
                    while (!foundRightBracket) {
                        if (curTop != '(') {
                            result.push(s1.pop());
                            curTop = s1.peek();
                        } else {
                            foundRightBracket = true;
                            s1.pop();
                        }
                    }
                } else if (getPriority(c) > getPriority(curTop)) {
                    s1.push(c);
                } else {
                    boolean foundPriorityLower = false;

                    while (!foundPriorityLower) {
                        curTop = s1.peek();
                        if (curTop == '#') {
                            foundPriorityLower = true;
                        } else if (getPriority(c) <= getPriority(curTop)) {
                            result.push(s1.pop());
                        } else {
                            foundPriorityLower = true;
                        }
                    }
                    if (c != '#') {
                        s1.push(c);
                    }
                }
            }
        }


        while (s1.size() != 0) {
            Character character = s1.pop();
            if (character == '#') {
                break;
            } else {
                result.push(character);
            }
        }

        LinkedList<Object> list = new LinkedList();
        while (!result.empty()) {
            list.addFirst(result.pop());
        }

        String out = list.stream().map(Object::toString).collect(Collectors.joining(", "));
        System.out.println("out = " + out);

        return new ArrayList<>(list);
    }

    HashMap<Character, Integer> priorityMap = new HashMap<>();

    Solution() {
        priorityMap.put('#', 0);
        priorityMap.put('(', 1);
        priorityMap.put('+', 4);
        priorityMap.put('-', 4);
        priorityMap.put('*', 8);
        priorityMap.put('/', 8);
        priorityMap.put(')', 16);
    }

    public int getPriority(char c) {
        return priorityMap.get(c);
    }

}
