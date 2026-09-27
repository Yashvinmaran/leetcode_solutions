class Solution {

    class Pair<K, V>{
        K k;
        V v;
        Pair(K k, V v){
            this.k = k;
            this.v = v;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        int[] ans = new int[k];
        Map<Integer, Integer> map =  new HashMap<>();

        for (int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.v, b.v));

        for (var m : map.keySet()){
            pq.add(new Pair(m, map.get(m)));
            if(pq.size() > k) pq.poll();
        }

        for (int i = 0; i < k; i++){
            Pair pr = pq.poll();
            ans[i] = (int)pr.k;
        }
        return ans;
    }
}
