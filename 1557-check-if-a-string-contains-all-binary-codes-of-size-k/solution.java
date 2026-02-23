// class Solution {
//     public boolean hasAllCodes(String s, int k) {
//         int n = s.length();
//         if (n < k) return false;
//         HashSet<String> set = new HashSet<>();
//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < k; i++) {
//             sb.append(s.charAt(i));
//         }
//         set.add(sb.toString());
//         for (int i = k; i < n; i++) {
//             sb.deleteCharAt(0);
//             sb.append(s.charAt(i));
//             set.add(sb.toString());
//         }
//         int end = (int) Math.pow(2, k);
//         for (int i = 0; i < end; i++) {
//             String binaryStr = String.format("%"+k+"s",Integer.toBinaryString(i)).replace(' ','0');
//             if (!set.contains(binaryStr)) return false;
//         }
//         return true;
//     }
// }


class Solution {
    public boolean hasAllCodes(String s, int k) {
        int need = 1 <<k;
        int n = s.length();

        if(n<k || n-k+1 < need)
        return false;

        boolean[] seen = new boolean[need];
        int hash = 0;
        int allOnes = need -1;
        int count = 0;

        for(int i=0; i<n; i++) {
            hash = ((hash << 1) & allOnes) | (s.charAt(i) - '0');
             if(i >= k-1){
                if(!seen[hash]){
                    seen[hash]=true;
                    count++;
                    if(count == need)
                    return true;
                }
             }
        }
        return false;
    }
}
