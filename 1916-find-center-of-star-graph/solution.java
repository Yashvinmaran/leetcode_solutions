// class Solution {
//     public int findCenter(int[][] edges) {
//         int n = edges.length + 1;

//         List<List<Integer>> adj = new ArrayList<>();

//         for(int i = 0; i <= n; i++){
//             adj.add(new ArrayList<>());
//         }

//         for (int i = 0; i <= n; i++){
//             adj.get(edges[i][0]).add(edges[i][1]);
//         }

//         int node = -1;
//         int maxLen = 0;

//         for (int i = 1; i <= n; i++){
//             if(a.size() > maxLen){
//                 maxLen = a.size();
//                 node = i
//             }
//         }
//         return node;
//     }
// }


class Solution {
    public int findCenter(int[][] edges) {
        // The center must be one of the two nodes in the first edge.
        // We just check which one appears in the second edge.
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        } else {
            return edges[0][1];
        }
    }
}

