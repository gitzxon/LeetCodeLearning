package study.circle.JudgeRouteCircle;

class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'U') {
                y -= 1;
            } else if (c == 'D') {
                y += 1;
            } else if (c == 'L') {
                x -= 1;
            } else if (c == 'R') {
                x += 1;
            }
        }

        return x == 0 && y == 0;

    }
}