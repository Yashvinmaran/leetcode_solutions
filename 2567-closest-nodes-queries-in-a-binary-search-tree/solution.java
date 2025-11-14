class Solution {
    List<Integer> arr = new ArrayList<>();
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        inorder(root);

        List<List<Integer>> ans = new ArrayList<>();

        for (int q : queries) {
            int min = findFloor(q);  
            int max = findCeil(q);
            ans.add(Arrays.asList(min, max));
        }

        return ans;
    }

    private int findFloor(int q) {
        int left = 0, right = arr.size() - 1;
        int res = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) <= q) {
                res = arr.get(mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    private int findCeil(int q) {
        int left = 0, right = arr.size() - 1;
        int res = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) >= q) {
                res = arr.get(mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}

