class Solution {
public:
    int count = 0;
    string result = "";
    
    void generate(int n, string current, char lastChar, int &k) {
        if (current.size() == n) {
            count++;
            if (count == k) result = current;
            return;
        }
        
        for (char c : {'a', 'b', 'c'}) {
            if (c != lastChar) {
                generate(n, current + c, c, k);
                if (!result.empty()) return;
            }
        }
    }
    
    string getHappyString(int n, int k) {
        generate(n, "", '#', k);
        return result;
    }
};
