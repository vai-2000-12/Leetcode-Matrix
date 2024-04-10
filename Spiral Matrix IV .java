class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for(int [] row : matrix){
             Arrays.fill(row, -1);
        }
        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;

        while (head != null) { 
            // Traverse from left to right:
            for (int i = left; i <= right && head != null ; i++) {
                matrix[up][i] = head.val;
                head = head.next;
            }
            up++;

            // Traverse from top to bottom:
            for (int i = up; i <= down && head != null ; i++) {
                matrix[i][right] = head.val;
                head = head.next;
            }
            right--;

            // Traverse from right to left
            if (up <= down) {
                for (int i = right; i >= left && head != null ; i--) {
                    matrix[down][i] = head.val;
                    head = head.next;
                }
                down--;
            }

            if (left <= right) {
                for (int i = down; i >= up && head != null ; i--) {
                    matrix[i][left] = head.val; 
                    head = head.next;
                }
                left++;
            }
        }
        return matrix;
    }
}
