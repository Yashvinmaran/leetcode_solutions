class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (hasCycleBFS(grid, i, j, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean hasCycleBFS(char[][] grid, int r, int c, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        char targetChar = grid[r][c];
        
        // Queue stores int[]{row, col, parentRow, parentCol}
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c, -1, -1});
        visited[r][c] = true;

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cr = curr[0], cc = curr[1], pr = curr[2], pc = curr[3];

            for (int[] dir : dirs) {
                int nr = cr + dir[0];
                int nc = cc + dir[1];

                // Check boundaries
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == targetChar) {
                    if (visited[nr][nc]) {
                        // If visited and not the immediate parent, it's a cycle
                        if (nr != pr || nc != pc) return true;
                    } else {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc, cr, cc});
                    }
                }
            }
        }
        return false;
    }
}

