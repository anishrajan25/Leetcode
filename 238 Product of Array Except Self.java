class Solution {
    public int[] productExceptSelf(int[] nums) {
        int r=1;
        int[] ans=new int[nums.length];
        ans[0]=1;
        for(int i=1;i<nums.length;ans[i]=nums[i-1]*ans[i++-1]);
        for(int i=nums.length-1;i>=0;i--)
        {
            ans[i]*=r;
            r*=nums[i];
        }
        return ans;
    }
}