class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l=0,r=nums.length,c=-1;
        while(l<r)
        {
            int i=l;
            while(i<r && nums[i]==1)
                i++;
            c=Math.max(c,i-l);
            l=i+1;
        }
        return c;
    }
}