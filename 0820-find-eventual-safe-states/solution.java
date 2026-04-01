import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer>[] rev = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            rev[i] = new ArrayList<>();
        }

        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int v : graph[i]) {
                rev[v].add(i);
                indegree[i]++;
            }
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for (int prev : rev[node]) {
                if (--indegree[prev] == 0) {
                    q.offer(prev);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}
