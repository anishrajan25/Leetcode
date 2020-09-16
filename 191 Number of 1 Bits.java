public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int s=0;
        while(n!=0)
        {
            if((n&1)!=0) s++;
            n>>>=1;
        }
        return s;
    }
}