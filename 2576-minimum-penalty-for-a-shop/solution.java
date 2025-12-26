class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            if(customers.charAt(i) == 'Y')arr[i] = 1;
            else arr[i] = 0;
        }
        
        int total_sum = 0;
        for (int i = 0; i < n; i++){
            total_sum += arr[i];
        }

        int small = total_sum;
        int result = 0;
        if(small == 0)return 0;
        for (int i = 0; i<n; i++){
            if(arr[i] == 1){
                total_sum -= 1;
            }else total_sum += 1;

            if(total_sum < small){
                small = total_sum;
                result = i + 1;
            }
        }
        return result;
    }
}
