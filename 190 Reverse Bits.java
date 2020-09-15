public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int[] num=new int[32];
        int i=0;
        while(i<32) {
            num[i++]=(n&1);
            n>>=1;
        }
        i--;
        int r=0,p=1;
        while(i>=0) {
            r+=num[i]*p;
            p*=2;
            i--;
        }
        return r;
    }
}