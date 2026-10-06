// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         if(root == null) return new ArrayList<>();

//         List<Integer> ans = new ArrayList<>();

//         Queue<TreeNode> qu = new ArrayDeque<>();

//         qu.offer(root);

//         while(!qu.isEmpty()){
//             int size = qu.size();
//             int val = 0;
//             for(int i = 0; i < size; i++){
//                 TreeNode node = qu.poll();
//                 val = node.val;
//                 if(node.left != null) qu.offer(node.left);
//                 if(node.right != null) qu.offer(node.right);
//             }

//             ans.add(val);
//         }

//         return ans;
//     }
// }

class Solution {

    private static void dfs(TreeNode root, int level, List<Integer> ans){
        if(root == null) return;

        if(level == ans.size()){
            ans.add(root.val);
        }

        ans.set(level, root.val);

        dfs(root.left, level + 1, ans);
        dfs(root.right, level + 1, ans);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
         
        List<Integer> ans = new ArrayList<>();

        dfs(root, 0, ans);

        return ans;
    }
}
