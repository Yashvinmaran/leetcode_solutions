class Solution {
    public void solve(TreeNode root,Map<Integer,ArrayList<int[]>>map,int idx,int r){
        if(map.containsKey(idx))map.get(idx).add(new int[]{r,root.val});
        else{
            map.put(idx,new ArrayList<>());
            map.get(idx).add(new int[]{r,root.val});
        }
        if(root.left!=null)solve(root.left,map,idx-1,r+1);
        if(root.right!=null)solve(root.right,map,idx+1,r+1);
        return;
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,ArrayList<int[]>>map=new TreeMap<>();
        List<List<Integer>>list=new ArrayList<>();
        solve(root,map,0,0);

        for (List<int[]> values : map.values()) {
            values.sort((a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });

            List<Integer> temp = new ArrayList<>();

            for (int[] node : values) {
                temp.add(node[1]);
            }

            list.add(temp);
        }
        return list;
    }
}
