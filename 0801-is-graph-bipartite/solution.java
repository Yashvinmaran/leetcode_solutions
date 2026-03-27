import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visit = new int[n]; 
        for (int i = 0; i < n; i++) {
            if (visit[i] == 0) { 
                Queue<Integer> qu = new LinkedList<>();
                qu.add(i);
                visit[i] = 1; 
                while (!qu.isEmpty()) {
                    int node = qu.poll();
                    for (int neighbor : graph[node]) {
                        if (visit[neighbor] == 0) {
                            visit[neighbor] = -visit[node];
                            qu.add(neighbor);
                        } else if (visit[neighbor] == visit[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

