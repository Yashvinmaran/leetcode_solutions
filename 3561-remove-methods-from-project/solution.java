class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // Fix 1: Correctly initialize adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Fix 2: Build the graph using the input array correctly
        for (int[] invocation : invocations) {
            int a = invocation[0];
            int b = invocation[1];
            adj.get(a).add(b);
        }

        // Fix 3: BFS to find all suspicious methods reachable from k
        boolean[] isSuspicious = new boolean[n]; // renamed 'visit' to 'isSuspicious' for clarity
        Queue<Integer> qu = new LinkedList<>();
        qu.add(k);
        isSuspicious[k] = true;

        while (!qu.isEmpty()) {
            int node = qu.poll();
            for (int neighbor : adj.get(node)) {
                if (!isSuspicious[neighbor]) {
                    isSuspicious[neighbor] = true;
                    qu.add(neighbor);
                }
            }
        }

        // Fix 4: Check if any non-suspicious method invokes a suspicious method
        boolean canRemove = true;
        for (int[] invocation : invocations) {
            int u = invocation[0];
            int v = invocation[1];
            // If u is NOT suspicious but calls v (which IS suspicious), we cannot remove
            if (!isSuspicious[u] && isSuspicious[v]) {
                canRemove = false;
                break;
            }
        }

        // Fix 5: Build the result list
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // If we can remove, only add non-suspicious methods.
            // If we cannot remove, add ALL methods.
            if (canRemove) {
                if (!isSuspicious[i]) {
                    ans.add(i);
                }
            } else {
                ans.add(i);
            }
        }
        
        return ans;
    }
}

