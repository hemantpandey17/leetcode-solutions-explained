public class Solution {
    public void rotate(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        transpose(matrix);
        swap_cols(matrix);
        
        
    }
    
    public void transpose(int[][] matrix) {
         for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){ 
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    public void swap_cols(int[][]matrix) {
        for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
    
}

/*
Complexity Analysis

Let M be the number of cells in the grid.

Time complexity : O(M). We perform two steps; transposing the matrix, and then reversing each row. Transposing the matrix has a cost of O(M) because we're moving the value of each cell once. Reversing each row also has a cost of O(M), because again we're moving the value of each cell once.

Space complexity : O(1) because we do not use any other additional data structures.
*/

/*
For anticlockwise, reverse and swap rows

*/
