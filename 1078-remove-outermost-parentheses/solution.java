class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int depth = 0;

        for(char c : s.toCharArray()){
            if(c == '('){
                if(depth > 0) 
                    sb.append(c);
                depth++;
            } else {
                depth--;
                if(depth > 0)
                    sb.append(c);
            }
        }
        return sb.toString();
    }
}




// class Solution {
//     public String removeOuterParentheses(String s) {
//        List<String> list = new ArrayList<>();
//        int cnt = 0;
//        StringBuilder sb = new StringBuilder();
//        for (char c : s.toCharArray()){
//         if(c == '(')cnt++;
//         if(c == ')')cnt--;
//         sb.append(c);
//         if(cnt == 0){
//             list.add(sb.toString());
//             sb.delete(0, sb.length());
//         }
//        }

//        for (String str : list){
//         for (int i = 1; i < str.length() - 1; i++){
//             sb.append(str.charAt(i));
//         }
//        }
//        return sb.toString();
//     }
// }
