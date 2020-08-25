class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0)
            return -1;
        if(nums.length==1)
            return nums[0];
        int res=Integer.MIN_VALUE,mps=0;
        int[] ps=new int[nums.length];
        ps[0]=nums[0];
        for(int i=1;i<nums.length;i++)
            ps[i]=ps[i-1]+nums[i];
        for(int i=0;i<nums.length;i++)
        {
            res=Math.max(res,ps[i]-mps);
            mps=Math.min(mps,ps[i]);
        }
        return res;
    }
}