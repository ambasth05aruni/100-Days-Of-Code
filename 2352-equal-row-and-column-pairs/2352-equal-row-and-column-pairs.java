class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length, count = 0;
        int[][] transpose = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transpose[i][j] = grid[j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Arrays.equals(grid[i], transpose[j])) {
                    count++;
                }
            }
        }
        return count; 
    }
}