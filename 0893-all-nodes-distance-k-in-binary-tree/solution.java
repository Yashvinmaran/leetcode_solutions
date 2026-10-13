class Solution {

    private Map<TreeNode, TreeNode> parent = new HashMap<>();

    private void inorderFillParentNode(TreeNode root){
        if(root == null) return;

        parent.put(root.left, root);
        inorderFillParentNode(root.left);

        parent.put(root.right, root);
        inorderFillParentNode(root.right);
    }

    private void BFS(TreeNode root, int k, List<Integer> ans, TreeNode target){
        
        Queue<TreeNode> qu = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();

        qu.add(target);
        set.add(target.val);

        while(!qu.isEmpty()){

            int n = qu.size();

            

            if(k == 0)break;

            while(n-- > 0){
                TreeNode curr = qu.poll();

                if(curr.left != null && !set.contains(curr.left.val)){
                    set.add(curr.left.val);
                    qu.add(curr.left);
                }

                if(curr.right != null && !set.contains(curr.right.val)){
                    set.add(curr.right.val);
                    qu.add(curr.right);
                }

                if(parent.containsKey(curr) && !set.contains(parent.get(curr).val)){
                    set.add(parent.get(curr).val);
                    qu.add(parent.get(curr));
                }
            }
            k--;

        }

        while(!qu.isEmpty()){
            ans.add(qu.poll().val);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> ans = new ArrayList<>();

        // int cnt = 0;

        // map.put(root, null);
        inorderFillParentNode(root);
        BFS(root, k, ans, target);
        return ans;
    }
}
