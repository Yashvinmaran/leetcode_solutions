class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> qu = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        qu.offer(0);
        visited[0] = true;
        int steps = 0;

        while (!qu.isEmpty()) {
            int size = qu.size();
            
            for (int i = 0; i < size; i++) {
                int idx = qu.poll();

                if (idx == n - 1) return steps;


                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    visited[idx - 1] = true;
                    qu.offer(idx - 1);
                }

                if (idx + 1 < n && !visited[idx + 1]) {
                    visited[idx + 1] = true;
                    qu.offer(idx + 1);
                }

                if (map.containsKey(arr[idx])) {
                    List<Integer> jumpIndices = map.get(arr[idx]);
                    for (int nextIdx : jumpIndices) {
                        if (!visited[nextIdx]) {
                            visited[nextIdx] = true;
                            qu.offer(nextIdx);
                        }
                    }
                    map.remove(arr[idx]);
                }
            }
            steps++;
        }
        
        return steps;
    }
}

