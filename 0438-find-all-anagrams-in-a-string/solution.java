class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        for (int i = 0; i <= (n-m); i++){
            if(isValid(s.substring(i, (i + m)), p))list.add(i);
        }
        return list;
    }
    private boolean isValid(String str, String p){
        int[] arr = new int[26];
        for(int i = 0; i<str.length(); i++){
            arr[str.charAt(i)-'a']++;
        }
        for(int i = 0; i<p.length(); i++){
            arr[p.charAt(i)-'a']--;
        }
        for (int i : arr){
            if(i != 0)return false;
        }
        return true;
    }
}
