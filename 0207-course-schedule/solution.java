class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        
        // Step 1: Create graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        // Step 2: Build graph and indegree
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        // Step 3: Add all 0 indegree nodes
        Queue<Integer> qu = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                qu.add(i);
            }
        }

        // Step 4: BFS
        int cnt = 0;
        while (!qu.isEmpty()) {
            int node = qu.poll();
            cnt++;

            for (int nei : graph.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    qu.add(nei);
                }
            }
        }

        // Step 5: Check if all courses finished
        return cnt == n;
    }
}
