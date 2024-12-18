class Solution {
public:
    vector<string> sortPeople(vector<string>& names, vector<int>& heights) {
        vector<pair<int,string>>pairVector;
        if (names.size() != heights.size()) return {};

        for (int i = 0; i<names.size(); i++){
            pairVector.push_back(make_pair(heights[i], names[i]));
        }

        sort(pairVector.rbegin(), pairVector.rend());
        names.resize(pairVector.size());
        int i = 0;
        for (auto p: pairVector){
            names[i++] = p.second;
        }
        return names;
    }
};

