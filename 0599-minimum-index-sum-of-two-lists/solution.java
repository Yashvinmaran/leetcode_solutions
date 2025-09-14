class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer>hm=new HashMap<>();
        List<String>al=new ArrayList<>();
        for(int i=0;i<list1.length;i++){
            hm.put(list1[i],i);
        }
        int sum=Integer.MAX_VALUE;
         for(int i=0;i<list2.length;i++){
            if(hm.containsKey(list2[i])){
                int s=hm.get(list2[i])+i;
                if(sum<s)continue;
                if(sum==s)al.add(list2[i]);
                if(sum>s){
                    while(al.size()>0)al.remove(al.size()-1);
                    sum=s;
                    al.add(list2[i]);
                }

            }
        }
        String[]arr=new String[al.size()];
        for(int i=0;i<al.size();i++){
            arr[i]=al.get(i);
        }
        return arr;
    }
}
