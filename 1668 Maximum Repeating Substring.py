# https://leetcode.com/problems/maximum-repeating-substring/

class Solution:
    def maxRepeating(self, sequence: str, word: str) -> int:
        k = 0
        w = word
        while w in sequence:
            w += word
            k += 1
        return k