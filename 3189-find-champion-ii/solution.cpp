class Solution {
public:
    int findChampion(int n, vector<vector<int>>& edges) {
        vector<int> inDegree(n, 0); 
        vector<vector<int>> adj(n);

        for (const auto& edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].push_back(v);
            inDegree[v]++;
        }

        int candidate = -1;
        for (int i = 0; i < n; ++i) {
            if (inDegree[i] == 0) {
                if (candidate != -1) {
                    return -1; 
                }
                candidate = i;
            }
        }

        if (candidate == -1) return -1;  
        vector<bool> visited(n, false);
        dfs(candidate, adj, visited);

        for (int i = 0; i < n; ++i) {
            if (!visited[i] && i != candidate) {
                return -1;
            }
        }

        return candidate;
    }

private:
    void dfs(int node, const vector<vector<int>>& adj, vector<bool>& visited) {
        visited[node] = true;
        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
};

