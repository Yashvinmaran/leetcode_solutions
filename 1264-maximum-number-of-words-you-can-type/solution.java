class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] textArray = text.split(" ");
        Set<Character> set = new HashSet<>();
        for (char c : brokenLetters.toCharArray()){
            set.add(c);
        }
        int ans = 0;
       for (String str : textArray){
        boolean flag = true;
        for (char c : str.toCharArray()){
            if(set.contains(c)){
                flag = false;
                break;
            }
        }
        if(flag)ans++;
       }
       return ans;
    }
}

