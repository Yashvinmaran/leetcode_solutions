class Solution {
    private void bfs(List<List<Integer>> adj, int i, int n, boolean[] visit){
        Queue<Integer> qu = new LinkedList<>();
        qu.add(i);
        while(!qu.isEmpty()){
            int node = qu.poll();
            for (int j : adj.get(node)){
                if(!visit[j]){
                    qu.add(j);
                    visit[j] = true;
                }
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visit = new boolean[n];
        visit[0] = true;
        for (int i = 0; i < n; i++){
            if(visit[i])bfs(rooms, i, n, visit);
        }

        for (int i = 0; i < n; i++){
            if(!visit[i])return false;
        } 
        return true;
    }
}
