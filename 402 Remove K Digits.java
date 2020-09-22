class Solution {
    public String removeKdigits(String nums, int k) {
        int l=nums.length();
        if(l==0 || k==0) return nums;
        if(k==l) return "0";
        char[] c = new char[l];
        int i=0,top=0,d=l-k;
        while(i<l) {
            char x=nums.charAt(i);
            while(top>0 && k>0 && c[top-1]>x) {
                top-=1;
                k-=1;
            }
            c[top++]=x;
            i++;
        }
        i=0;
        while(i<d && c[i]=='0') i++;
        return i==d ? "0" : new String(c,i,d-i);
    }
}