class Solution {

    private boolean checkSubIsaland(int[][] grid1, int[][] grid2, int i, int j) {

        // we traversed all the element within a grid
        if(i < 0 || i >= grid1.length || j < 0 || j >= grid1[0].length) {
            return true;
        }

        // we are not checking the cell with value 0
        // we only need to check land grid2[i][j] == 1
        if(grid2[i][j] != 1) {
            return true;
        }

        grid2[i][j] = -1; // mark visited

        // grid[i][j] must contains 1 to make a sub island
        boolean result = (grid1[i][j] == 1);

        // perform DFS on all four directions. i.e. Down, Up, Right, Left
        result = result & checkSubIsaland(grid1, grid2, i+1, j); // Down
        result = result & checkSubIsaland(grid1, grid2, i-1, j); // Up
        result = result & checkSubIsaland(grid1, grid2, i, j+1); // Right
        result = result & checkSubIsaland(grid1, grid2, i, j-1); // Left

        return result;

    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int subIslands = 0;
        int m = grid2.length; // number of rows
        int n = grid2[0].length; // number of columns

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid2[i][j] == 1 && checkSubIsaland(grid1, grid2, i, j)) { // found a sub islands
                    subIslands++;
                }
            }
        }

        return subIslands;
    }
}