public class Solution {
    public boolean exist(char[][] board, String word) {
        
        int rows= board.length;
        int cols = board[0].length;
        
        for(int i=0; i< rows; i++) {
            for(int j=0; j<cols;j++) {
                if(explore(board,i,j,0,word)) {
                    return true;
                }
            }
        }
        
        return false;
        
    }
    
    public boolean explore(char[][] board, int i, int j, int pos, String s) {
        
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) {
            return false;
        }
        
        if(board[i][j] == s.charAt(pos)) {
            // Marking as visited
            char temp = board[i][j];
            
            board[i][j]= '$';
            
            // If all characters are matched
            if(pos==s.length()-1) {
                return true;
            }
            
            else if 
                (explore(board,i-1,j,pos+1,s)||
                explore(board,i+1,j,pos+1,s) ||
                explore(board,i,j-1,pos+1,s) ||
                explore(board,i,j+1,pos+1,s)
            ) {
                return true;
            }
            board[i][j] = temp;
        }
        return false;
        
    }
}
