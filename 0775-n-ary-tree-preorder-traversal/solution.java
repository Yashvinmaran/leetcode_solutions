class Solution {
    private void helper(Node root, List<Integer>list){
        if(root == null)return;
        list.add(root.val);

        for(Node child : root.children){
            helper(child, list);
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer>list = new ArrayList<>();
        helper(root, list);
        return list;
    }
}
