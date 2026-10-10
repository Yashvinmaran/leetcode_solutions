class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        
        int n = nums1.length;
        int[] diffFreq = new int[100001];
        int maxDiff = 0;

        long reduceCnt = (long)k1 + k2;

        for (int i = 0; i < n; i++){
            int diff = Math.abs(nums1[i] - nums2[i]);
            diffFreq[diff]++;

            if(maxDiff < diff){
                maxDiff = diff;
            }
        }

        for (int d = maxDiff; d > 0 && reduceCnt > 0; d--){

            if(diffFreq[d] == 0)continue;

            int currFreq = diffFreq[d];

            if(currFreq <= reduceCnt){
                diffFreq[d - 1] += currFreq;
                diffFreq[d] = 0;
                reduceCnt -= currFreq; 
            }else{
                diffFreq[d - 1] += reduceCnt;
                diffFreq[d] -= reduceCnt;
                reduceCnt = 0;
            }
        }

        long minimizeSum = 0L;

        for (long i = 1; i <= maxDiff; i++){
            long currSquare = (long)i * i;
            minimizeSum += (diffFreq[(int)i] * currSquare);
        }

        return minimizeSum;
    }
}
