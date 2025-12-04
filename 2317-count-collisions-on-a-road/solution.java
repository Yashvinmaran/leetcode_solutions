class Solution {
    public int countCollisions(String dir) {
        
        int n = dir.length();
        int left = 0, right = n - 1;
        int ans = 0;

        while(left < n && dir.charAt(left) == 'L')left++;
        while(right >= 0 && dir.charAt(right) == 'R')right--;

        for (int d = left; d <= right; d++){
            if(dir.charAt(d) != 'S')ans++;
        }
        return ans;
    }
}
