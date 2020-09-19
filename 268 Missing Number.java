class Solution {
    public int missingNumber(int[] nums) {
        if(nums.length==0) return -1;
        int s=nums.length*(nums.length+1)/2;
        for(int i:nums) s-=i;
        return s;
    }
}