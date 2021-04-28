class Solution {
    public void setZeroes(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        
        boolean row = false;
        boolean col = false;
        
        // Only marking the first entry of ith row and jth column as 0, and if the value of i and j is 0, then we make boolean variables taken above as               true. We will have to process 0 in first row and column separately as they can make whole matrix 0 if not done so
        for(int i=0; i< numRows; i++) {
            for(int j=0; j<numCols; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if(i == 0)
                        row = true;
                    if(j == 0)
                        col =true;
                }
            }
        }
        
        
        for(int i=1; i < numRows; i++) {
            if(matrix[i][0] == 0) {
                for(int j=1; j<numCols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for(int j=1; j<numCols; j++) {
            if(matrix[0][j] == 0) {
                for(int i=1; i<numRows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(row) {
            for(int j=0;j<numCols; j++) {
                matrix[0][j] = 0;
            }
        }
        
        if(col) {
            for(int i=0; i<numRows; i++) {
                matrix[i][0] = 0;
            }
        }
        
    }
}
