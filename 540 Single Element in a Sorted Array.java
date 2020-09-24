class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==0) return -1;
        int l=0,s=nums.length-1,h=s;
        while(l<h) {
            int m=l+(h-l)/2;
            if(nums[m]==nums[m+1]) l=m;
            else h=m;
        }
        return nums[l+1];
    }
}