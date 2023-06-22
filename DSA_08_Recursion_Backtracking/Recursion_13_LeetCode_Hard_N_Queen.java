import java.util.*;
public class Recursion_13_LeetCode_Hard_N_Queen {

    public static List<List<String>> solveNQueens(int n){
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<>();
        solve(0,board,res);
        return res;
    }

    public static boolean isSafe(char[][] board,int row,int col){
        int duprow = row;
        int dupcol = col;
        // For cheking the North-West Direction
        while(row>=0 && col>=0){
            if(board[row][col]=='Q') return false;
            row--;
            col--;
        }
        // For cheking in the left direction 
        row = duprow;
        col = dupcol;
        while(col>=0){
            if(board[row][col]=='Q') return false;
            col--; 
        }
        // For South-West Direction
        row = duprow;
        col = dupcol;
        while(col>=0 && row<=board.length){
            if(board[row][col]=='Q') return false;
            col--;
            row++;
        }
        return true;
    }

    public static void solve(int col,char[][] board,List<List<String>> res){
        if(col == board.length){
            res.add(construct(board));
            return;
        }

        for(int row=0;row<board.length;row++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                solve(col+1,board,res);
                board[row][col] = '.';
            }
        }

    }

    public static List<String> construct(char[][] board){
        List<String> res = new LinkedList<>();
        for(int i=0;i<board.length;i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        
        int N = 4;
        List<List<String>> queen = solveNQueens(N);
        int i = 1;
        for(List<String> it : queen){
            System.out.println("Arrangement " + i);
            for(String s : it){
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }

    }
}
