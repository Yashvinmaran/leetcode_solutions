class Solution {

    private void bfs(List<List<Integer>> adj, int node, List<Integer> curr, int n){
        Queue<Integer> qu = new LinkedList<>();
        boolean[] visit = new boolean[n];

        qu.add(node);
        visit[node] = true;

        while(!qu.isEmpty()){
            int currNode = qu.poll();

            for (int neb : adj.get(currNode)){
                if(!visit[neb]){
                    visit[neb] = true;
                    qu.add(neb);
                    curr.add(neb);
                }
            }
        }
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][1]).add(edges[i][0]); // reverse graph
        }

        for (int i = 0; i < n; i++){
            List<Integer> curr = new ArrayList<>();
            bfs(adj, i, curr, n);
            Collections.sort(curr);
            ans.add(curr);
        }

        return ans;
    }
}
