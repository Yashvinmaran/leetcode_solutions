class Solution {
    public String freqAlphabets(String s) {
        List<Integer> list = new ArrayList<>();

        for (int i = s.length() - 1; i >= 0; i--){
            int ans = 0;
            if(s.charAt(i) == '#'){
                int b = s.charAt(i - 1) - '0';
                int a = s.charAt(i - 2) - '0';
                ans += (a * 10 + b);
                i -= 2;
            }else{
                ans += s.charAt(i) - '0';
            }
            list.add(ans);
        }

        StringBuilder sb = new StringBuilder();

        for (int idx : list){
            sb.append((char)('a' + idx - 1));
        }

        return sb.reverse().toString();
    }
}
