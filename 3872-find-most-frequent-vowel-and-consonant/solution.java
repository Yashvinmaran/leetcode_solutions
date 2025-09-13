class Solution {
    public boolean isVowel(char c){
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
    public int maxFreqSum(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int max1 = 0;
        int max2 = 0;
        for (char c : map.keySet()){
            if(isVowel(c))max1 = Math.max(map.get(c), max1);
            else max2 = Math.max(map.get(c), max2);
        }
        return max1 + max2;
    }
}
