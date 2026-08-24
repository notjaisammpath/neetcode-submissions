class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> output;
        int nextInd = 0;
        std::unordered_map<std::string, int> map;
        for(int i = 0; i < strs.size(); i++) {
            std::string curr = strs[i];
            std::sort(curr.begin(), curr.end());

            if(map.contains(curr)) {
                output[map[curr]].push_back(strs[i]);
            }
            else {
                map[curr] = nextInd;
                output.push_back({}); 
                output[nextInd].push_back(strs[i]);
                nextInd++;
            }
        }
        return output;
    }
};
