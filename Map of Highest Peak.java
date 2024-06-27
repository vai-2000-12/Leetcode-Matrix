class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        int[][] height = new int[m][n];
        for (int[] row : height) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    q.add(new Pair(i, j));
                }
            }
        }

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int r = curr.x;
            int c = curr.y;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                // Boundary Condition:
                if (nr < m && nc < n && nr >= 0 && nc >= 0 && height[nr][nc] > 1 + height[r][c]) {
                    height[nr][nc] = 1 + height[r][c];
                    q.add(new Pair(nr, nc));
                }
            }
        }
        return height;
    }
}
