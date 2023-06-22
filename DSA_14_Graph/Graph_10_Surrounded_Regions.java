public class Graph_10_Surrounded_Regions {

    public static void dfs(int row, int col, char[][] matrix,int[][] visited, int[] moveRow, int[] moveCol){
        visited[row][col] = 1;
        int Row = matrix.length , Col = matrix[0].length;
        for(int move=0;move<4;move++){
            int move_row = Row + moveRow[move];
            int move_col = Col + moveCol[move];
            if(move_row>=0 && move_row<Row && 
            move_col>=0 && move_col<Col && 
            visited[move_row][move_col]==0 &&
            matrix[move_row][move_col]=='O'){
                dfs(move_row, move_col, matrix, visited, moveRow, moveCol);
            }
        }
    }

    public static char[][] fill(char[][] matrix){
        int Row = matrix.length;
        int Col = matrix[0].length;
        int[] moveRow = {-1, 0, 1, 0};
        int[] moveCol = {0, 1, 0, -1};
        int[][] visited = new int[Row][Col];
        // Traverse First and Last Row
        for(int i=0;i<Col;i++){
            if(visited[0][i]==0 && matrix[0][i]=='O'){
                dfs(0, i, matrix, visited, moveRow, moveCol);
            }
            if(visited[Row-1][i]==0 && matrix[Row-1][i]=='O'){
                dfs(Row-1, i, matrix, visited, moveRow, moveCol);
            }
        }

        // Traverse First and Last Col
        for(int j=0;j<Row;j++){
            if(visited[j][0]==0 && matrix[j][0]=='O'){
                dfs(j, 0, matrix, visited, moveRow, moveCol);
            }
            if(visited[j][Col-1]==0 && matrix[j][Col-1]=='O'){
                dfs(j, Col-1, matrix, visited, moveRow, moveCol);
            }
        }

        for(int i=0;i<Row;i++){
            for(int j=0;j<Col;j++){
                if(visited[i][j]==0 && matrix[i][j]=='O') matrix[i][j] = 'X';
            }
        } 
        return matrix;
    }

    public static void printArray(char[][] arr){
        int n=arr.length , m = arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        char[][] matrix = {{'X', 'X', 'X', 'X'}, 
                            {'X', 'O', 'X', 'X'}, 
                            {'X', 'O', 'O', 'X'}, 
                            {'X', 'O', 'X', 'X'}, 
                            {'X', 'X', 'O', 'O'}};
        System.out.println("The Modified Array : ");
        printArray(fill(matrix));
    }
    
}
