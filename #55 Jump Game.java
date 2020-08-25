class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length<=1) return true;
        int ind=-1,i=nums.length-2;
        while(i>=0)
        {
            if(nums[i]==0) {
                ind=i--;
                while(i>=0 && (nums[i]+i)<=ind)
                    i--;
                if(i>=0)
                    ind = -1;
            }
            i--;
        }
        return ind == -1;
    }
}