"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

import heapq
class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        intervals.sort(key=lambda x : x.start)
        heap = []

        for time in intervals:
            if heap and heap[0] <= time.start:
                heapq.heappop(heap)
            heapq.heappush(heap, time.end)
        
        return len(heap)
            
        