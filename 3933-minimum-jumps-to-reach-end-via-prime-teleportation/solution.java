class Solution {

    private boolean isPrime(int num) {

        if (num <= 1) return false;

        if (num == 2 || num == 3) return true;

        if (num % 2 == 0 || num % 3 == 0) return false;

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    public int minJumps(int[] nums) {

        int n = nums.length;

        if (n == 1) return 0;

        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        // value -> indices
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.offer(0);
        vis[0] = true;

        int jumps = 0;

        // avoid reprocessing same prime
        Set<Integer> usedPrime = new HashSet<>();

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int i = q.poll();

                if (i == n - 1) {
                    return jumps;
                }

                // left
                if (i - 1 >= 0 && !vis[i - 1]) {
                    vis[i - 1] = true;
                    q.offer(i - 1);
                }

                // right
                if (i + 1 < n && !vis[i + 1]) {
                    vis[i + 1] = true;
                    q.offer(i + 1);
                }

                int val = nums[i];

                // prime jumps
                if (isPrime(val) && !usedPrime.contains(val)) {

                    usedPrime.add(val);

                    // visit multiples of val
                    for (int multiple = val; multiple <= max; multiple += val) {

                        if (map.containsKey(multiple)) {

                            for (int idx : map.get(multiple)) {

                                if (!vis[idx]) {
                                    vis[idx] = true;
                                    q.offer(idx);
                                }
                            }
                        }
                    }
                }
            }

            jumps++;
        }

        return -1;
    }
}
