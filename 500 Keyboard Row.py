# https://leetcode.com/problems/keyboard-row/

class Solution:
    r1 = ['Q','W','E','R','T','Y','U','I','O','P']
    r2 = ['A','S','D','F','G','H','J','K','L',]
    r3 = ['Z','X','C','V','B','N','M']
    
    def check(self, word, row):
        for x in word:
            if x not in row:
                return False
        return True
    
    def findWords(self, words: List[str]) -> List[str]:
        ans = []
        for w in words:
            if self.check(w.upper(), self.r1) or self.check(w.upper(), self.r2) or self.check(w.upper(), self.r3):
                ans.append(w)
        return ans