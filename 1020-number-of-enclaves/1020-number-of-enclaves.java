class Solution {
    public int numEnclaves(int[][] grid) {
          int count = 0;
        
		//Go through each boundary cell and dfs for all directions setting all 1's in path to 0's
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j++){
                if(i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1){
                    recurse(grid, i, j);
                }
            }
        }
        
        //after replacing 1's which can lead to boundary if 1's left then increment count 
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    
    void recurse(int[][] grid, int i, int j){
	//if you find 0 in the path or reach another boundary then return
        if(i < 0 || i  >= grid.length || j  < 0 || j  >= grid[0].length || grid[i][j] == 0){
            return;
        }
        grid[i][j] = 0;
		//search all directions for 1's
        recurse(grid, i - 1, j);
        recurse(grid, i  + 1, j);
        recurse(grid, i, j - 1);
        recurse(grid, i, j + 1);
    }
}