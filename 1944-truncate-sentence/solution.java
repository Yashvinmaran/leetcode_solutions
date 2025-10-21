class Solution {
    public String truncateSentence(String s, int k) {
        String[] strArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : strArr){
            k--;
            sb.append(str);
            if(k == 0)break;
            sb.append(" ");
        }
        return sb.toString();
    }
}
