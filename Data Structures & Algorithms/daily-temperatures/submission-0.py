from collections import deque


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        q = deque()
        output = [0] * len(temperatures)
        for i in range(len(temperatures) - 1, -1, -1):
            if not q:
                print(i)
                output[i] = 0
                q.append(i)
                continue
            while q and temperatures[q[-1]] <= temperatures[i]:
                q.pop()
            if q:
                output[i] = q[-1] - i
            else:
                output[i] = 0
            q.append(i)
        return output
