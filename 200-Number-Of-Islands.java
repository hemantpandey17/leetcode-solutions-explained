/*
Intuition

Treat the 2d grid map as an undirected graph and there is an edge between two horizontally or vertically adjacent nodes of value '1'.

Algorithm

Linear scan the 2d grid map, if a node contains a '1', then it is a root node that triggers a Depth First Search. During DFS, every visited node should be set as '0' to mark as visited node. Count the number of root nodes that trigger DFS, this number would be the number of islands since each DFS starting at some root identifies an island.
*/

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(grid == null || m == 0)
            return 0;
        int n = grid[0].length;
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    ++count;
                    DFS(grid,i,j);
                }
            }
        }
        return count;
    }
    private void DFS(char[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        DFS(grid,i+1,j);
        DFS(grid,i-1,j);
        DFS(grid,i,j+1);
        DFS(grid,i,j-1);
    }
}

/*
Complexity Analysis

Time complexity : O(M×N) where M is the number of rows and N is the number of columns.

Space complexity : worst case O(M×N) in case that the grid map is filled with lands where DFS goes by M×N deep.
*/
