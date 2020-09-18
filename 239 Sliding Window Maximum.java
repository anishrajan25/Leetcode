// https://leetcode.com/problems/sliding-window-maximum/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1 ) return nums;
        int ans[] = new int[nums.length - k + 1];
        int mi = getIndex(nums, 0, k-1);
        ans[0] = nums[mi];
        int i = 1, j = k;
        while(j < nums.length) {
            if(nums[j] >= nums[mi]) mi = j;
            else if(i-1 == mi) mi = getIndex(nums, i, j);
            ans[i++] = nums[mi];
            j++;
        }
        
        return ans;
    }
    
    private int getIndex(int arr[], int s, int e) {
        int i = s++;
        while(s<=e) {
            if(arr[s]>=arr[i]) i = s;
            s++;
        }
        
        return i;
    }
}