class Solution {

    private static void findRightView(TreeNode root, int level, List<Integer> list){
        if(root == null)return;

        if(list.size() == level){
            list.add(root.val);
        }
        list.set(level, root.val);
        findRightView(root.left, level + 1, list);
        findRightView(root.right, level + 1, list);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root == null)return list;

        findRightView(root, 0, list);

        return list;
    }
}
