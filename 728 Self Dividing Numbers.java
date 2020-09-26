// https://leetcode.com/problems/self-dividing-numbers/

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> out = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (divisible(i)) { out.add(i); }
        }
        return out;
    }
    private boolean divisible(int n) {
        int m = n;
        while (m > 0) {
            if (m % 10 == 0) { return false; }
            if (n % (m % 10) !=  0) { return false; }
            m /= 10;
        }
        return true;
    }
}