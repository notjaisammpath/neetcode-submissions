class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordSet = set(wordDict)
        memo = {}
        def dfs(ind):
            if ind == len(s):
                return True
            if ind in memo:
                return memo[ind]
            for end in range(ind + 1, len(s) + 1):
                if s[ind:end] in wordSet and dfs(end):
                    memo[ind] = True
                    return True
            memo[ind] = False
            return False
        return dfs(0)