class Solution {
    public int[][] generateMatrix(int n) {  
      int m = n;
      int[][] matrix = new int[m][n];
      int up = 0;
      int down = m-1;
      int left =  0;
      int right = n-1;
      int count = 1;

      while(left <= right && up <= down){
         // traverse from left to right -- up++
         for(int i = left ; i<=right ; i++){
            matrix[up][i] = count;
            count++;
         }
         up++;
          
         // traverse from top to bottom:
         for( int i = up ; i <=down ; i++){
            matrix[i][right] = count;
            count++;
         } 
         right--;

         // traverse from right to left:
          
          if(up <= down){
             for( int i = right ; i >=left ; i--){
                matrix[down][i] = count;
                count++;
             }
              down--;
          }

          // traverse from down to top:
          if(left <= down){
            for( int i = down ; i>=up ; i--){
                matrix[i][left] = count;
                count++;
            }
            left++;
          }
      }
     return matrix;
    }
}