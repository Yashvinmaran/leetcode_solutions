class Solution {
    public int minimizedStringLength(String s) {
        int [] farr=new int[26];
        for(int i=0;i<s.length();i++){
            farr[s.charAt(i)-'a']++;
        }int count=0;
        for(int i:farr){
            if(i>0)count++;
        }return count;
    }
}
