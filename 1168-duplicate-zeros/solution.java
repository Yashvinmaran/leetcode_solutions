class Solution {
    public void duplicateZeros(int[] arr) {
        int zero=0;
        for(int count=0;count<arr.length;count++){
            if(arr[count]==0)zero++;
        }
        int n =arr.length;
        for(int i=n-1;i>=0;i--){
            if(i+zero<n){
                arr[i+zero]=arr[i];
            }
            if(arr[i]==0){
                zero--;
                if(i+zero<n){
                    arr[i+zero]=0;
                }
            }
        }
    }
}
