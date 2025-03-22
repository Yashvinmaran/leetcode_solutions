class Solution {
    public :
    string frequencySort(string s) {
        unordered_map<char,int>mp;

        for (int i = 0; i<s.length(); i++){
            mp[s[i]]++;
        }
        priority_queue<pair<int,char>>pq;
        for (auto d : mp){
            pq.push({d.second,d.first});
        }
         string ans = "";
        while(pq.size() > 0){
            for (int i = 0; i<pq.top().first; i++){
                ans +=  pq.top().second;
            }
            pq.pop();
        }
        return ans;
    }
};
