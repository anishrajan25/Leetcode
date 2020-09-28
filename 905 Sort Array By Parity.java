class Solution {
    public int[] sortArrayByParity(int[] A) {
        int ans[]=new int[A.length],l=0,r=A.length-1;
        for(int k: A)
        {
            if(k%2==0)
                ans[l++]=k;
            else
                ans[r--]=k;
        }
        return ans;
    }
}