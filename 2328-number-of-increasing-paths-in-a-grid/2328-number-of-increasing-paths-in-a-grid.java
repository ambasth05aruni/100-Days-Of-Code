class Solution {
    public int countPaths(int[][] grid) {
          int path [][] = new int[grid.length][grid[0].length];
        for(int[] x : path){
            Arrays.fill(x, -1);
        }
        int total = 0;
        for(int i = 0; i < grid.length ; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(path[i][j] == -1){
                    countPath(grid, i, j, path, Integer.MIN_VALUE);
                }
                total = (total +  path[i][j]) % (int)(1e9 + 7);
            }
        }
        return total;

    }
    public int countPath(int[][] grid, int i , int j, int[][] path, int prev ){
        if(i<0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return 0;
        }
        if(prev >= grid[i][j]){return 0;}
        if(path[i][j] != -1){
            return path[i][j];
        }
        
        else{
            int x1 = 1;
            x1 = (x1 + countPath(grid,i+1,j,path,grid[i][j])) % (int)(1e9 + 7);
            x1 = (x1 + countPath(grid,i-1,j,path,grid[i][j])) % (int)(1e9 + 7);
            x1 = (x1 + countPath(grid,i,j+1,path,grid[i][j])) % (int)(1e9 + 7);
            x1 = (x1 + countPath(grid,i,j-1,path,grid[i][j])) % (int)(1e9 + 7);
            path[i][j] = x1;
            return  path[i][j] ;
        }
    }
}