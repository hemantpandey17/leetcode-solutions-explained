class Solution {
    
    /*
    public int uniquePaths(int m, int n) {
        
        int[][] matrix = new int[m][n]; // 2-D DP Matrix
        
        for(int i = 0; i < m; i++) { // Filling the first column of matrix as 1
            matrix[i][0] = 1;
        }
        
        for(int j = 0; j < n ; j++) { // Filling the first row of matrix as 1
            matrix[0][j] = 1;
        }
        
        for(int i=1 ; i<m ; i++) {
            for(int j=1 ; j<n ; j++) {
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1]; // Filling the DP matrix with this formula, each entry in the matrix                                                                            determines the number of ways required to reach that particular block from                                                                    the start.
            }
        }
        
        return matrix[m-1][n-1]; 
    }
    */
    
 
    public int uniquePaths(int m, int n) {
        int[] arr = new int[m]; // 1-D array
        
        // Popuating the initial 1-D array with all enteries as 1
        for (int i = 0; i < m; i++) {
            arr[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                arr[j] = arr[j] + arr[j-1]; // The new value in array is equal to value at same index in old array plus previous entry in new                                               array
            }
        }
        return arr[m-1];
    }
}
