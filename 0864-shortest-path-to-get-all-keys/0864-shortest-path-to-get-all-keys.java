class Solution {
    public int shortestPathAllKeys(String[] grid) {
       int m = grid.length;
        int n = grid[0].length();
        int all = 0;
        int[] start = null;
        char[][] g = new char[m][n];

        for (int i = 0; i < m; i++) {
            g[i] = grid[i].toCharArray();
            for (int j = 0; j < n; j++) {
                if (g[i][j] == '@') {
                    start = new int[]{i, j};
                } else if (g[i][j] >= 'a' && g[i][j] <= 'f') {
                    all |= 1 << (g[i][j] - 'a');
                }
            }
        }

        int[][][] dist = new int[m][n][1 << 6];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }

        LinkedList<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], 0});
        dist[start[0]][start[1]][0] = 0;

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int keys = cur[2];
            if (keys == all) {
                return dist[x][y][keys];
            }
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                int nkeys = keys;
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || g[nx][ny] == '#') {
                    continue;
                }
                if (g[nx][ny] >= 'a' && g[nx][ny] <= 'f') {
                    nkeys |= 1 << (g[nx][ny] - 'a');
                }
                if (g[nx][ny] >= 'A' && g[nx][ny] <= 'F' && (nkeys & (1 << (g[nx][ny] - 'A'))) == 0) {
                    continue;
                }
                if (dist[nx][ny][nkeys] != -1) {
                    continue;
                }
                dist[nx][ny][nkeys] = dist[x][y][keys] + 1;
                q.offer(new int[]{nx, ny, nkeys});
            }
        }
        return -1;   
    }
}