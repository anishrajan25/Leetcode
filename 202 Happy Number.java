class Solution {
    public boolean isHappy(int n) {
        if(n==1 || n==7)
            return true;
        if(n==0)
            return false;
        int sq=0;
        while(true)
        {
            sq=0;
            while(n!=0)
            {
                int x=n%10;
                sq+=(x*x);
                n/=10;
            }
            if(sq/10==0)
                break;
            n=sq;
        }
        if(sq==1 || sq==7)
            return true;
        return false;
    }
}