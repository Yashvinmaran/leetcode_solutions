class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length, cnt = 0;
        int[] ans = new int[n];
        int[] freq = new int[n + 1];
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < n; i++){
        //     map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            
        //     for (int j = i; j >= 0; j--){
        //         if(map.containsKey(B[j]) && map.get(B[j]) > 0){
        //             cnt++;
        //             map.put(B[j], map.get(B[j]) - 1);
        //         }
        //     }
        //     ans[i] = cnt;
        // }

        for (int i = 0; i < n; i++){
            freq[A[i]]++;
            if(freq[A[i]] == 2)cnt++;
            // ans[i] = cnt;
            freq[B[i]]++;
            if(freq[B[i]] == 2)cnt++;
            ans[i] = cnt;
        }

        return ans;
    }
}
