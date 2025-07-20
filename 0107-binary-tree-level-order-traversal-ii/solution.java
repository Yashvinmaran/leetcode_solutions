class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>(); 
        Queue<TreeNode> qu = new LinkedList<>();

        if(root != null) qu.add(root);

       while(!qu.isEmpty()){
        int size = qu.size();
        List<Integer> level = new LinkedList<>();

        for (int i = 0; i<size; i++){
            TreeNode temp = qu.poll();
            level.add(temp.val);
            if(temp.left != null)qu.add(temp.left);
            if(temp.right != null)qu.add(temp.right);
        }
        result.add(0, level);
       }
        return result;
    }
}

