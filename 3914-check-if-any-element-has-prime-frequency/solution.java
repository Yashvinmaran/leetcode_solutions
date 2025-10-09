class Solution {
    public boolean isPrime(int n){
        if (n <= 1)return false;
        if(n == 2)return true;

        for (int i = 2; i<n; i++){
            if(n%i == 0)return false;
        }
        return true;
    }
    public boolean checkPrimeFrequency(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int key : map.keySet()){
            if(isPrime(map.get(key)))return true;
        }
        return false;
    }
}
