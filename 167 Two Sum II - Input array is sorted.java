// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0, j = numbers.length-1;
        while(i < j){
            int sum = numbers[i] + numbers[j];
            if(sum == target) return new int[]{i+1,j+1};
            else if(sum > target) --j;
            else ++i;
        }
        
        return new int[]{};
    }
}

// class Solution {
//     private int findPair(int[] nums, int l, int x) {
//         int r = nums.length - 1;
//         while(l < r) {
//             int m = l + (r-l)/2;
//             if(nums[m] == x) return m+1;
//             else if(nums[m] > x) r--;
//             else l++;
//         }
//         return nums[l] == x ? l+1 : -1;
//     }
    
//     public int[] twoSum(int[] numbers, int target) {
//         for(int i = 0; i < numbers.length; ++i) {
//             int ind = findPair(numbers, i+1, target - numbers[i]);
//             if(ind > 0) return new int[]{i+1, ind};
//             while(i<numbers.length-1 && numbers[i] == numbers[i+1]) i++;
//         }
        
//         return new int[2];
//     }
// }