// By the help of DFS 

// class Solution {

//     private static void traversalDFS(TreeNode root, int level, List<List<Integer>> list){
//         if(root == null)return;

//         if(level == list.size()){
//             list.add(new ArrayList<>());
//         }

//         if(level % 2 == 1){
//             list.get(level).add(0, root.val);
//         }else{
//             list.get(level).add(root.val);
//         }
//         traversalDFS(root.left, level + 1, list);
//         traversalDFS(root.right, level + 1, list);
//     }

//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

//         List<List<Integer>> list = new ArrayList<>();

//         if(root == null)return list;

//         traversalDFS(root, 0, list);

//         return list;
//     }
// }

// By the help of BFS

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null)
            return list;

        Queue<TreeNode> qu = new LinkedList<>();

        qu.offer(root);

        boolean flag = true;

        while (!qu.isEmpty()) {
            List<Integer> curr = new ArrayList<>();
            int size = qu.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = qu.poll();
                curr.add(node.val);
                if (node.left != null)
                    qu.offer(node.left);
                if (node.right != null)
                    qu.offer(node.right);
            }
            if (!flag) {
                Collections.reverse(curr);
                list.add(curr);
                flag = true;
            } else if(flag) {
                list.add(curr);
                flag = false;
            }
        }

        return list;
    }
}
