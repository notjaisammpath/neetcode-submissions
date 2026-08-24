class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
       std::unordered_map<int, int> map;
       for(int i = 0; i < nums.size(); i++){
            map[nums[i]]++;
       } 
       priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> minHeap;
       for(auto const& [val, freq] : map){
        minHeap.push({freq, val});
        if(minHeap.size() > k) {
            minHeap.pop();
        }
       }
        vector<int> output;
       for(int i = 0; i < k; i++) {
        output.push_back(minHeap.top().second);
        minHeap.pop();
       }
       return output;
    }
};
