class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
       int m = mat.length;
       int n = mat[0].length;
       int index = 0;
        // Can be the Boundary Traversal  
        if(m == 0 ||  n == 0){
            return new int[0];
        }

        // If the direct -- true toh up 
         // agr false hai toh == down: 
       boolean direction = true;
       int i = 0 , j = 0;
       int[] res = new int[m*n];

      while(i < m && j<n)
        {
            if(direction)
            {
                while(i>0 && j<n-1)
                {
                    res[index++]=mat[i][j];
                    i--;
                    j++;
                }
                res[index++]=mat[i][j];
                if(j==n-1)
                i++;
                else 
                {
                    j++;
                }
                    direction =false;
            }
            else
            {
                while(j > 0 && i < m-1)
                {
                    res[index++]=mat[i][j];
                    i++;
                    j--;
                }
                res[index++]=mat[i][j];
                if(i==m-1)
                j++;
                else 
                {
                    i++;
                }
                    direction =true;
            }
        }
        return res;
    }
}