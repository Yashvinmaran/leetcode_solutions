class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        int[] indegree = new int[n];

        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> qu = new LinkedList<>();
        for (int i = 0; i < n; i++){
            if(indegree[i] == 0)qu.add(i);
        }

        int[] ans = new int[n];
        boolean[] visit = new boolean[n];
        int idx = 0;
        if(qu.isEmpty())return new int[]{};

        while(!qu.isEmpty()){
            int node = qu.poll();
            for (int a : adj.get(node)){
                indegree[a]--;
                if(indegree[a] == 0)qu.add(a);
            }
            if(visit[node])return new int[]{};
            visit[node] = true;
            ans[idx++] = node;
        }

        return idx == n?ans:new int[]{};
    }
}
