import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        map = {}
        for n in nums:
            if n in map:
                map[n] = map[n] + 1
            else:
                map[n] = 1
        heap = []
        for n, f in map.items():
            heapq.heappush(heap, (f, n))
            if(len(heap) > k):
                heapq.heappop(heap)
        return [num for freq, num in heap]

        
    
        