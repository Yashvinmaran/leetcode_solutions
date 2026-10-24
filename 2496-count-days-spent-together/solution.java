class Solution {
    private final int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arriveA = toDays(arriveAlice);
        int leaveA = toDays(leaveAlice);
        int arriveB = toDays(arriveBob);
        int leaveB = toDays(leaveBob);

        int start = Math.max(arriveA, arriveB);
        int end = Math.min(leaveA, leaveB);

        return Math.max(0, end - start + 1);
    }

    private int toDays(String s) {
        int month = Integer.parseInt(s.substring(0, 2));
        int day = Integer.parseInt(s.substring(3, 5));
        int totalDays = day;
        for (int i = 1; i < month; ++i) {
            totalDays += days[i];
        }
        return totalDays;
    }
}

