class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        
        int initialFuel = mainTank;
        int totalFuel = 0;


        for (int i = 5; i <= mainTank && additionalTank > 0; i = i + 5){
            totalFuel ++;
            mainTank++;
            additionalTank--;
        }

        totalFuel += initialFuel;

        int totalDistance =  totalFuel * 10;
        return totalDistance;
    }
}
