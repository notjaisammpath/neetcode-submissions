class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = defaultdict(list)
        for course, pre, in prerequisites:
            graph[course].append(pre)
        
        visited = set()
        currVisit = set()

        def dfs(course):
            if course in visited:
                return True
            if course in currVisit:
                return False
            currVisit.add(course)
            for prereq in graph[course]:
                if not dfs(prereq):
                    return False
            visited.add(course)
            currVisit.remove(course)
            return True
        
        for course in range(numCourses):
            if not dfs(course):
                return False
        return True
        