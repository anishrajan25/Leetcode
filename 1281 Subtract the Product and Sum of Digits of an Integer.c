// https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/

int subtractProductAndSum(int n){
    int p = 1, s = 0;
    while(n) {
        int t = n % 10;
        p *= t;
        s += t;
        n /= 10;
    }
    return p - s;
}