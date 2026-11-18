from collections import deque
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordSet = set(wordList)
        if endWord not in wordSet:
            return 0
        q = deque()
        q.append(beginWord)
        output = 1
        while q:
            for _ in range(len(q)):
                curr = q.popleft()
                if curr == endWord:
                    return output
                for i in range(len(curr)):
                    for c in "abcdefghijklmnopqrstuvwxyz":
                        newWord = curr[:i] + c + curr[i + 1:]
                        if newWord in wordSet:
                            wordSet.remove(newWord)
                            q.append(newWord)
            output += 1
        return 0