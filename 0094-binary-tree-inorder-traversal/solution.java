// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();

//         TreeNode curr = root;

//         while(curr != null){
//             if(curr.left == null){
//                 ans.add(curr.val);
//                 curr = curr.right;
//             }else{
//             TreeNode leftChild = curr.left;
//             while(leftChild.right != null){
//                 leftChild = leftChild.right;
//             }

//             leftChild.right = curr;
//             TreeNode temp = curr;
//             curr = curr.left;
//             temp.left = null;
//             }
//         }

//         return ans;
//     }
// }







class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;

        while(curr != null || !st.isEmpty()){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            ans.add(curr.val);
            curr = curr.right;
        }

        return ans;
    }
}
