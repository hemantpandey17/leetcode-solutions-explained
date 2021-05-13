 public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i=0; i<9; i++) {
            if (!isParticallyValid(board,i,0,i,8)) // For all rows
                return false;
            if (!isParticallyValid(board,0,i,8,i)) // For all cloumns
                return false;
        }
        for (int i=0;i<3;i++){ // For all cube boxes
            for(int j=0;j<3;j++){
                if (!isParticallyValid(board,i*3,j*3,i*3+2,j*3+2)) return false;
            }
        }
        return true;
    }
    private boolean isParticallyValid(char[][] board, int x1, int y1,int x2,int y2){
        Set singleSet = new HashSet();
        for (int i= x1; i<=x2; i++){
            for (int j=y1;j<=y2; j++){
                if (board[i][j]!='.') 
                    if(!singleSet.add(board[i][j])) 
                        return false;
            }
        }
        return true;
    }
}

/*
isParticallyValid(char[][] board, int x1, int y1,int x2,int y2) is a boolean function which takes the range of rows (x1,x2) and range of columns (y1,y2) and see if there is any duplicate enteries within the enteries in that range using HashSet

*/
