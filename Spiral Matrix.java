class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0;
        int down = m-1;
        int left = 0;
        int right = n-1;
    
       while (up <= down && left <= right) {
            // Traverse from left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            up++;

            // Traverse from top to bottom
            for (int i = up; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Traverse from right to left
            if (up <= down) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[down][i]);
                }
                down--;
            }

            // Traverse from bottom to top
            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}