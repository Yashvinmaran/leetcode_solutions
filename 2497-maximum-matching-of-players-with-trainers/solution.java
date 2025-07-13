class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int n1 = players.length;
        int n2 = trainers.length;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = 0, j = 0, c = 0;
        while(i < n1 && j < n2){
            if(players[i] <= trainers[j]){
                c++;
                i++;
                j++;
            }else if(players[i] > trainers[j])j++;
        }
        return c;
    }
}
