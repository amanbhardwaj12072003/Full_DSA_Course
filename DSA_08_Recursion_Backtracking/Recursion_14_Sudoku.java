import java.util.*;
public class Recursion_14_Sudoku {

    public static boolean Solve(List<List<Character>> board){
        for(int i=0;i<board.size();i++){
            for(int j=0;j<board.size();j++){
                if(board.get(i).get(j)=='.'){    // Note that this is the method to access the (i,j) element in a 2-D ArrayList..
                    // A for loop with variable char..
                    for(char c='1';c <='9';c++){
                        if(isValid(board,i,j,c)){
                            board.get(i).set(j,c);  // Method to set an element in 2-Dimensional ArrayList
                        }
                        if(Solve(board))
                            return true;
                        else
                            board.get(i).set(j,'.');
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(List<List<Character>> board,int row,int col,char c){
        for(int i=0;i<board.size();i++){ 
            if(board.get(row).get(i)==c)
                return false;
            else if(board.get(i).get(col)==c)
                return false;
            else if(board.get(3*(row/3) + i/3).get(3*(col/3) + i%3)==c)
                return false;
    
        }
        return true;
    }

    public static void Fun(List<List<Character>> board){
        Solve(board);
    }

    public static void main(String[] args) {

        List<List<Character>> board = new ArrayList<>();
        
         String[][] board_={{"5","3",".",".","7",".",".",".","."},
                            {"6",".",".","1","9","5",".",".","."},
                            {".","9","8",".",".",".",".","6","."},
                            {"8",".",".",".","6",".",".",".","3"},
                            {"4",".",".","8",".","3",".",".","1"},
                            {"7",".",".",".","2",".",".",".","6"},
                            {".","6",".",".",".",".","2","8","."},
                            {".",".",".","4","1","9",".",".","5"},
                            {".",".",".",".","8",".",".","7","9"}};
        

                   
    }
}

