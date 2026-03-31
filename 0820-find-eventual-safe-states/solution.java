class Solution {
    private boolean dfs(int i, int[][] graph, int[] state, List<Integer> ans) {
        if (state[i] == 1) return false;
        if (state[i] == 2) return true;

        state[i] = 1;

        for (int nei : graph[i]) {
            if (!dfs(nei, graph, state, ans)) return false;
        }
        state[i] = 2;
        ans.add(i);
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        int[] state = new int[n];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            dfs(i, graph, state, ans);
        }

        Collections.sort(ans);
        return ans;
    }
}

