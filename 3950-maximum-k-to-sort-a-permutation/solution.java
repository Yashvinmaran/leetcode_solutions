class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        if (isSorted(nums)) return 0; // already sorted

        int k = 0; // build k from high bits to low bits
        for (int bit = 30; bit >= 0; bit--) {
            int testK = k | (1 << bit);
            if (canSort(nums, testK)) {
                k = testK;
            }
        }
        return k;
    }

    private boolean canSort(int[] nums, int k) {
        int n = nums.length;
        UnionFind uf = new UnionFind(n);

        // Connect indices whose nums[i] contains all bits of k
        // and share enough bits to allow swapping
        for (int i = 0; i < n; i++) {
            if ((nums[i] & k) == k) { // candidate element
                // Try to union with position nums[i] should go to
                int target = nums[i];
                if ((nums[target] & k) == k) {
                    uf.union(i, target);
                }
            }
        }

        // Verify that each number can reach its sorted position
        for (int i = 0; i < n; i++) {
            if (uf.find(i) != uf.find(nums[i])) return false;
        }
        return true;
    }

    private boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) return false;
        }
        return true;
    }

    static class UnionFind {
        int[] parent;
        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        void union(int a, int b) {
            parent[find(a)] = find(b);
        }
    }
}

