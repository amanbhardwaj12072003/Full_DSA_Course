
/*
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image.
Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel
value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting 
pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same 
color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor. 
*/

public class Graph_05_Flood_Fill_Algorithm {

    public static void dfs(int row,int col,int[][] ans,int[][] image, int newColor, int[] moveRow, int[] moveCol,int initialColor){
        ans[row][col] = newColor;
        int Row = image.length ,Col = image[0].length;
        for(int move=0;move<4;move++){
            int move_row = row + moveRow[move];
            int move_col = col + moveCol[move];
            if(move_row>=0 && move_col>=0 && move_row<Row && move_col < Col && 
            image[move_row][move_col]==initialColor && ans[move_row][move_col]!=newColor){
                dfs(move_row, move_col, ans, image, newColor, moveRow, moveCol, initialColor);
            }
        }
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1},
                        {1,1,0},
                        {1,0,1}};
        /*
        Expected Output 
        {
            {2,2,2},
            {2,2,0},
            {2,0,1},
        }
        */
        int Row = image.length,Col = image[0].length, sr = 1, sc = 1, newColor = 2;
        int initialColor = image[sr][sc];
        int[][] ans = new int[Row][Col];
        for(int i=0;i<Row;i++) for(int j=0;j<Col;j++) ans[i][j] = image[i][j];
        int[] moveRow = {-1 , 0 , +1 , 0};
        int[] moveCol = {0 , +1 , 0 , -1};
        dfs(sr,sc,ans,image,newColor,moveRow,moveCol,initialColor);
        System.out.println("Ans : " );
        printArray(ans);
    }
    public static void printArray(int[][] arr){
        int row = arr.length , col = arr[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
