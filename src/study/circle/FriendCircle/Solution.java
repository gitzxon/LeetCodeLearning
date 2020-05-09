package study.circle.FriendCircle;

class Solution {
    public int findCircleNum(int[][] friends) {
        if (friends.length == 0) return 0;
        if (friends.length == 1) return 1;

        int peopleCount = friends.length;
        int[] visited = new int[peopleCount];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = 0;
        }

        int count = 0;

        for (int i = 0; i < peopleCount; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(friends, visited, i);
            }
        }

        return count;
    }

    public void dfs(int[][] friends, int[] visited, int i) {
        for (int j = 0; j < friends[i].length; j++) {
            if (friends[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(friends, visited, j);
            }
        }
    }
}