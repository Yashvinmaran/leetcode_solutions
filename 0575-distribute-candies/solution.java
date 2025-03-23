class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        int eatMax = (n / 2);
        HashSet<Integer>st = new HashSet<>();
        for (int c : candyType){
            st.add(c);
        }
        if(eatMax > st.size()){
            return st.size();
        }
        return (n / 2);
    }
}
