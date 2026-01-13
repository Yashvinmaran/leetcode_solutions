class Solution {
    public String dayOfTheWeek(int day, int month, int year) {

        String[] days = {
            "Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday", "Saturday"
        };

        int[] monthCode = {
            0, 3, 3, 6, 1, 4,
            6, 2, 5, 0, 3, 5
        };

        int centuryCode;
        if (year >= 2000 && year < 2100) centuryCode = 6;
        else if (year >= 1900 && year < 2000) centuryCode = 0;
        else if (year >= 2100 && year < 2200) centuryCode = 4;
        else centuryCode = 2;

        int y = year % 100;
        int oddDays = day + monthCode[month - 1] + y + y / 4 + centuryCode;

        if (isLeap(year) && month <= 2) {
            oddDays -= 1;
        }

        return days[oddDays % 7];
    }

    private boolean isLeap(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }
}

