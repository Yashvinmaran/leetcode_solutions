class Solution {
    public int countCompleteComponents(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] visit = new boolean[n];
        int complete = 0;

        for (int i = 0; i < n; i++) {

            if (!visit[i]) {

                Queue<Integer> qu = new LinkedList<>();

                qu.add(i);
                visit[i] = true;

                int nodes = 0;
                int degreeSum = 0;

                while (!qu.isEmpty()) {

                    int node = qu.poll();
                    nodes++;

                    degreeSum += adj.get(node).size();

                    for (int next : adj.get(node)) {

                        if (!visit[next]) {
                            qu.add(next);
                            visit[next] = true;
                        }
                    }
                }

                int edgeCount = degreeSum / 2;

                if (edgeCount == (nodes * (nodes - 1)) / 2) {
                    complete++;
                }
            }
        }

        return complete;
    }
}
