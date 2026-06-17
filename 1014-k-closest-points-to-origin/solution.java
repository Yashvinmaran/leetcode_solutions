class Solution {

    public static class Pair<K, V> {
        public K k;
        public V v;
        Pair(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        
        // 2. Updated lambda variables to look at .v and .k to match your class fields
        // 3. Changed to a Max-Heap (b compared to a) because you are keeping the 'k' smallest elements 
        //    by continuously popping the largest element when size > k.
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
            int valueCompare = Integer.compare(b.v, a.v); 
            if (valueCompare == 0) {
                return Integer.compare(b.k, a.k);
            }
            return valueCompare;
        });

        for (int i = 0; i < points.length; i++) {
            int dist = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
            
            pq.add(new Pair<>(i, dist));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> cur = pq.poll();
            ans[--k][0] = points[cur.k][0];
            ans[k][1] = points[cur.k][1];
        }

        return ans;
    }
}

