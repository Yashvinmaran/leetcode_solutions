class Solution {

    public int longestCycle(int[] edges) {
        int n = edges.length;

        boolean[] visited = new boolean[n];
        int[] time = new int[n];

        int timer = 1;
        int maxCycle = -1;

        for (int i = 0; i < n; i++) {

            if (visited[i]) continue;

            int node = i;
            Map<Integer, Integer> map = new HashMap<>();

            while (node != -1) {

                if (visited[node]) {
                    if (map.containsKey(node)) {
                        int cycleLength = timer - map.get(node);
                        maxCycle = Math.max(maxCycle, cycleLength);
                    }
                    break;
                }

                visited[node] = true;
                map.put(node, timer++);
                node = edges[node];
            }
        }

        return maxCycle;
    }
}
