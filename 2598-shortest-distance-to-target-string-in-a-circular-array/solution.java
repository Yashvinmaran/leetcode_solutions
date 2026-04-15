class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int ans = -1;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int dist = Math.abs(i - startIndex);
                int circularDist = Math.min(dist, n - dist);
                
                if (ans == -1 || circularDist < ans) {
                    ans = circularDist;
                }
            }
        }
        return ans;
    }
}

