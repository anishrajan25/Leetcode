class Solution {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        if(nums.length==0 || k==0) return;
        int c=0;
        for(int s=0;c<nums.length;s++) {
            int prev=nums[s];
            int curr=s;
            do {
                int n=(curr+k)%nums.length;
                int t=nums[n];
                nums[n]=prev;
                prev=t;
                curr=n;
                c++;
            }while(curr!=s);
        }
    }
}