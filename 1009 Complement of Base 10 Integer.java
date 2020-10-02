class Solution {
    public int bitwiseComplement(int n) {
        int nob = (int)(Math.floor(Math.log(n) / Math.log(2))) + 1; 
        return ((1 << nob) - 1) ^ n;
    }
}