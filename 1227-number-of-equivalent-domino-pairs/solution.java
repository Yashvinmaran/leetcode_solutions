class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        int n = dominoes.length;
        
        for (int i = 0; i < n; i++) {
            int a = Math.min(dominoes[i][0], dominoes[i][1]);
            int b = Math.max(dominoes[i][0], dominoes[i][1]);
            String key = a + "," + b;
            
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int ans = 0;
        for (int freq : map.values()) {
            if (freq > 1) {
                ans += freq * (freq - 1) / 2;
            }
        }
        return ans;
    }
}

