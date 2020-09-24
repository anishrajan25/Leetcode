# https://leetcode.com/problems/random-flip-matrix/

import random
class Solution:

    def __init__(self, n_rows: int, n_cols: int):
        self.flipped = set()
        self.row = n_rows
        self.col = n_cols

    def flip(self) -> List[int]:
        while(True):
            el = random.randint(0, self.row * self.col - 1)
            if el in self.flipped: continue
            self.flipped.add(el)
            return [el//self.col, el%self.col]

    def reset(self) -> None:
        self.flipped = set()


# Your Solution object will be instantiated and called as such:
# obj = Solution(n_rows, n_cols)
# param_1 = obj.flip()
# obj.reset()