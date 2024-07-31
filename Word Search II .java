import java.util.*;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();

        for (String word : words) {
            if (word_search(board, word)) {
                ans.add(word);
            }
        }
        return ans;
    }

    public boolean word_search(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[m][n]; 
                    if (dfs(i, j, board, word, visited, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(int x, int y, char[][] board, String word, boolean[][] visited, int count) {
        if (count == word.length()) {
            return true;
        }

        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }

        if (visited[x][y] || board[x][y] != word.charAt(count)) {
            return false;
        }

        visited[x][y] = true;

        // Explore all 4 possible directions (up, down, left, right)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            if (dfs(x + dx[i], y + dy[i], board, word, visited, count + 1)) {
                return true;
            }
        }

        visited[x][y] = false; 
        return false;
    }
}
