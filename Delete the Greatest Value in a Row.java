import java.util.*;

class A {
    public   static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of the Matrix: ");
        int n = sc.nextInt();

        System.out.println(" Enter the Number of rows :" );
        int row  = sc.nextInt();
        
        System.out.println(" Enter the Number of cols :" );
        int cols = sc.nextInt();


        int[][] grid = new int[row][cols];

        System.out.println("Enter the Matrix You required : ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int result = deleteGreaterValue(grid);
        System.out.println("Result: " + result);
        sc.close();
    }

    public static int deleteGreaterValue(int[][] grid) {
        int res = 0;
        int n = grid[0].length;

        // Sort each row of the matrix
        for (int[] row : grid) {
            Arrays.sort(row);
        }

        // Iterate over each column starting from the last column to the first
        for (int col = n - 1; col >= 0; col--) {
            int max = Integer.MIN_VALUE;

            // Find the maximum value in the current column
            for (int[] row : grid) {
                max = Math.max(max, row[col]);
            }
            res += max;
        }
        return res;
    }
}

/*
  * Enter the Size of the Matrix:  3
  * Enter the Number of rows : 2
  * Enter the Number of cols : 3
  * Enter the Matrix You required :
    { [1 2 4]
     [3 3 1 ]}
* Result: 8
*/ 