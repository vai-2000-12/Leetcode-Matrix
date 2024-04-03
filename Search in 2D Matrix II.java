class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      int m = matrix.length;
      int n = matrix[0].length;
      int row = 0;
      int col = n - 1;
      while(col >= 0 && row <= m-1){
        if(target ==  matrix[row][col] ){
             return true;
        }else if( target > matrix[row][col]){
              row++;
        }else if( target  < matrix[row][col]){
             col--;
        }
      }
      return false;
    }
}