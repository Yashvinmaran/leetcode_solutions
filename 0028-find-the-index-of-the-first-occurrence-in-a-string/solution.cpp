class Solution {
public:
    int strStr(string haystack, string needle) {
        int s1 = haystack.size();
        int s2 = needle.size();
        int i = 0;

        if (s1<s2) return -1;
        if (s2 == 0) return 0;

       while (i <= (s1-s2)){
        if (haystack.substr(i,s2) == needle){
            return i;
        }else if ((haystack.substr(i,s2) != needle)){
            i++;
        }
       }
       return -1;
    }
};
