class Solution {
    private void bfs(int[][] adj, int i, boolean[] visit, int n){
        Queue<Integer> qu = new LinkedList<>();
        qu.add(i);
        visit[i] = true;
        while(!qu.isEmpty()){
            int node = qu.poll();
            for (int j = 0; j < n; j++){
                if(adj[node][j] == 1 && !visit[j]){
                    visit[j] = true;
                    qu.add(j);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean[] visit = new boolean[n];
        Queue<Integer> qu = new LinkedList<>();
        int cnt = 0;

        qu.add(isConnected[0][0]);
        for (int i = 0; i < n; i++){
            if(!visit[i]){
                bfs(isConnected, i, visit, n);
                cnt++;
            }
        }
        return cnt;
    }
}
