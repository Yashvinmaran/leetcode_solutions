class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minFinishTime = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {
                // Plan A: Water ride first, then Land ride
                int waterFinish = waterStartTime[j] + waterDuration[j];
                int planAFinish = Math.max(waterFinish, landStartTime[i]) + landDuration[i];

                // Plan B: Land ride first, then Water ride
                int landFinish = landStartTime[i] + landDuration[i];
                int planBFinish = Math.max(landFinish, waterStartTime[j]) + waterDuration[j];

                // Find the best option for this pair
                int currentPairMin = Math.min(planAFinish, planBFinish);

                // Update the global minimum finish time
                minFinishTime = Math.min(minFinishTime, currentPairMin);
            }
        }
        
        return minFinishTime;
    }
}

