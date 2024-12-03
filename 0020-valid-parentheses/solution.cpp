class Solution {
public:
    bool isValid(string s) {
        stack<char>st;
        for (auto p:s){
            if (p=='(' || p=='{' || p=='['){
                st.push(p);
            }else{
                if(st.empty()){
                    return false;
                    break;
                }
                char top = st.top();
                st.pop();

                if ( p == ')' && top != '(' || p == '}' && top != '{' || p == ']' && top != '['){
                    return false;
                }
            }
        }
        return (st.empty());
    }
};

