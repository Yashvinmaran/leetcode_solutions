class Solution {
private:
    void backtrack(int n, vector<string> &result, string current, int open, int closed) {
        if (current.size() == (n*2)) {
            result.push_back(current);
            return;
        }

        if (open > 0 && closed < open) {
            current += ")";
            backtrack(n, result, current, open, closed + 1);
            current.pop_back();
        }
        if (open < n) {
            current += "(";
            backtrack(n, result, current, open + 1, closed);
        }
        current.pop_back();
    }

public:
    vector<string> generateParenthesis(int n) {
        vector<string> result;
        string current;
        backtrack(n, result, current, 0, 0);
        return result;
    }
};
