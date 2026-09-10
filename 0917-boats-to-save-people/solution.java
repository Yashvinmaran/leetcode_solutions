class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int n = people.length;
        
        int i = 0;
        int j = n - 1;

        while(j >= 0 && people[j] >= limit){
            ans++;
            j--;
        }

        while(i <= j){
            if(people[i] + people[j] <= limit){
                i++;
            }
            j--; 
            ans++;
        }

        return ans;
    }
}

