public class DP_56_Count_Square_Matrices_With_Only_1 {

    // Tabulation Code 
    public static int count(int[][] matrix){
        int row = matrix.length , col = matrix[0].length;
        int[][] copy_matrix = new int[row][col];
        for(int x=0;x<row;x++) copy_matrix[x][0] = matrix[x][0];
        for(int y=0;y<col;y++) copy_matrix[0][y] = matrix[0][y];
        for(int x=1;x<row;x++){
            for(int y=1;y<col;y++){
                if(matrix[x][y] == 1) copy_matrix[x][y] = 1 + getValue(copy_matrix, x, y);
            }
        }
        int count = 0;
        for(int x=0;x<row;x++){
            for(int y=0;y<col;y++){
                count += copy_matrix[x][y];
            }
        }
        return count;
    }

    public static int getValue(int[][] grid,int x, int y){
        int val1 = grid[x-1][y];
        int val2 = grid[x][y-1];
        int val3 = grid[x-1][y-1];
        return Math.min(val1,Math.min(val2,val3));
    }

    public static void main(String[] args) {
        // Expected Output = 11
        int[][] matrix = {
            {1, 1, 1, 0},
            {1, 1, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        };
        System.out.println("The Number Of Square SubMatrices : " + count(matrix));
    }
}

