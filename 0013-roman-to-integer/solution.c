int romanToInt(char* s) {
    int total = 0;
    int values[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    char literals[] = "MCMXDCLXVI";
    int i = 0;
    while (*s != '\0') {
        if (strncmp(s, "M", 1) == 0) total += 1000;
        else if (strncmp(s, "CM", 2) == 0) { total += 900; s++; }
        else if (strncmp(s, "D", 1) == 0) total += 500;
        else if (strncmp(s, "CD", 2) == 0) { total += 400; s++; }
        else if (strncmp(s, "C", 1) == 0) total += 100;
        else if (strncmp(s, "XC", 2) == 0) { total += 90; s++; }
        else if (strncmp(s, "L", 1) == 0) total += 50;
        else if (strncmp(s, "XL", 2) == 0) { total += 40; s++; }
        else if (strncmp(s, "X", 1) == 0) total += 10;
        else if (strncmp(s, "IX", 2) == 0) { total += 9; s++; }
        else if (strncmp(s, "V", 1) == 0) total += 5;
        else if (strncmp(s, "IV", 2) == 0) { total += 4; s++; }
        else if (strncmp(s, "I", 1) == 0) total += 1;
        s++;
    }
    return total;
}
