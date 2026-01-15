class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        int total = 0;
        for (int i = 0; i < n; i++) total += distance[i];
        int dis = 0;
        if(destination < start){
            destination = destination + start;
            start = destination - start;
            destination = destination - start;
        }
        for (int i = start; i < destination; i++){
            int idx = (i % n);
            dis += (distance[idx]);
        }
        int ans = Math.min(total - dis, dis);
        return ans;
    }
}
