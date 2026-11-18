import heapq
import math
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        ind = 0
        output = []
        for l in points:
            hyp = math.sqrt(abs(l[0]* l[0]) + abs(l[1]* l[1]))
            heapq.heappush(output, (-hyp, ind, l))
            if(len(output) > k):
                heapq.heappop(output)
        return [l[2] for l in output]
        

        