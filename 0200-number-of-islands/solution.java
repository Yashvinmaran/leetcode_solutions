//More optimised code

class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    count ++;
                    dfs(grid, visited, r, c);
            }
            }
        }
        return count;
    }
        private void dfs(char[][] grid, boolean[][] visited, int r, int c) {
            int rows = grid.length;
            int cols = grid[0].length;
            if (r < 0 || c < 0 || r >= rows || c >= cols) return;
            if (grid[r][c] == '0' || visited[r][c]) return;

            visited[r][c] = true;
            //Xuong
            dfs(grid, visited, r + 1, c);
            //Trai
            dfs(grid, visited, r, c - 1);
            //Len
            dfs(grid, visited, r - 1, c);
            //Phai
            dfs(grid, visited, r, c + 1);
        }
    }


// class Solution {
//     class Pair{
//         int i;
//         int j;
//         Pair(int i, int j){
//             this.i = i;
//             this.j = j;
//         }
//     }

//     private void helper(char[][] grid, int r, int c, Queue<Pair> qu, int m, int n){
//         for (int i = r; i < m; i++){
//             if(grid[i][c] == '1') qu.add(new Pair(i, c));
//             else break;
//         }
//         for (int i = r - 1; i >= 0; i--){
//             if(grid[i][c] == '1') qu.add(new Pair(i, c));
//             else break;
//         }
//         for (int i = c; i < n; i++){
//             if(grid[r][i] == '1') qu.add(new Pair(r, i));
//             else break;
//         }
//         for (int i = c - 1; i >= 0; i--){
//             if(grid[r][i] == '1') qu.add(new Pair(r, i));
//             else break;
//         }
//     }

//     private void bfs(int row, int col, char[][] grid, boolean[][] visit, int m, int n){
//         Queue<Pair> qu = new LinkedList<>();
//         qu.add(new Pair(row, col));
//         while(!qu.isEmpty()){
//             Pair p = qu.poll();
//             int r = p.i;
//             int c = p.j;
//             if(!visit[r][c]){
//                 helper(grid, r, c, qu, m, n);
//             }
//             visit[r][c] = true;
//         }
//     }

//     public int numIslands(char[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int cnt = 0;
//         boolean[][] visit = new boolean[m][n];
//         for (int i = 0; i < m; i++){
//             for (int j = 0; j < n; j++){
//                 if(grid[i][j] == '1' && !visit[i][j]){
//                     cnt++;
//                     bfs(i,j,grid,visit,m,n);
//                 }
//             }
//         }
//         return cnt;
//     }
// }


