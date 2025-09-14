// class Solution {
//     public String capitalizeTitle(String title) {
//         List<String> list = new ArrayList<>();
//         int n = title.length();
//         String str = "";
//         for (int i = 0; i<n; i++){
//             str += title.charAt(i);
//             if(i == (n-1) || title.charAt(i) == ' '){
//                 list.add(str);
//                 str = "";
//             }
//         }
//         StringBuilder sb = new StringBuilder();
//         for (var s : list){
//             StringBuilder st = new StringBuilder(s.toLowerCase());
//             if(st.length() > 3 && st.charAt(0) > 'Z'){
//                 char old = st.charAt(0);
//                 char New = Character.toUpperCase(old);
//                 st.setCharAt(0,New);
//             }else if(st.length() >= 3 && st.charAt(0) > 'Z' && st.charAt(st.length() - 1) != ' '){
//                 char old = st.charAt(0);
//                 char New = Character.toUpperCase(old);
//                 st.setCharAt(0,New);
//             }
//             sb.append(st);
//         }
//         return sb.toString();
//     }
// }


class Solution {
    public String capitalizeTitle(String title) {
        StringBuilder sb = new StringBuilder();
        for(String s: title.split(" ")){
            if(s.length()>2){
                sb.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1).toLowerCase()).append(" ");
            }else{
                sb.append(s.toLowerCase()).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
