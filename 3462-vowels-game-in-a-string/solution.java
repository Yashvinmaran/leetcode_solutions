class Solution {
    public boolean doesAliceWin(String s) {
        HashSet<Character> v = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int cnt = 0 ;
         for(char c : s.toCharArray()){
            if(v.contains(c)) return true;
         }
     
        return false;
    }
}
