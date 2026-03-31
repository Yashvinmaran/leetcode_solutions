class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        int[] indegree = new int[n];

        // Step 1: Compute indegree
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                indegree[leftChild[i]]++;
                if (indegree[leftChild[i]] > 1) return false;
            }
            if (rightChild[i] != -1) {
                indegree[rightChild[i]]++;
                if (indegree[rightChild[i]] > 1) return false;
            }
        }

        // Step 2: Find root
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                if (root != -1) return false; // multiple roots
                root = i;
            }
        }

        if (root == -1) return false; // no root

        // Step 3: BFS
        boolean[] visit = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        visit[root] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            if (leftChild[node] != -1) {
                if (visit[leftChild[node]]) return false;
                visit[leftChild[node]] = true;
                q.add(leftChild[node]);
            }

            if (rightChild[node] != -1) {
                if (visit[rightChild[node]]) return false;
                visit[rightChild[node]] = true;
                q.add(rightChild[node]);
            }
        }

        // Step 4: Check connectivity
        for (boolean v : visit) {
            if (!v) return false;
        }

        return true;
    }
}
