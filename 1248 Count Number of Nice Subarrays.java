// https://leetcode.com/problems/count-number-of-nice-subarrays/

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int loc[] = new int[nums.length + 1];
        loc[0] = -1;
        int j = 1, res = 0;
        for(int i = 0; i < nums.length; ++i) {
            if((nums[i] & 1) == 1) {
                if(j > k) {
                    res += (loc[j - k] - loc[j - k - 1]) * (i - loc[j - 1]); 
                }
                loc[j++] = i;
            }
        }
        res += j > k ? (loc[j - k] - loc[j - k - 1]) * (nums.length - loc[j - 1]) : 0;
        return res;
    }
}



// class Solution {
//     public int numberOfSubarrays(int[] nums, int k) {
//         int loc[] = new int[nums.length + 1];
//         int j = 0;
//         for(int i = 0; i < nums.length; ++i) {
//             if((nums[i] & 1) == 1) loc[j++] = i;
//         }
//         if(j == 0) return 0;
//         loc[j]  = nums.length;
//         if(k == nums.length) return (loc[0] + 1) * (k - loc[j]);
//         int l = 1, r = k, res = (loc[0] + 1) * (loc[k] - loc[k - 1]);
//         while(r < j) {
//             res += (loc[l] - loc[l - 1]) * (loc[r + 1] - loc[r]);
//             r++;
//             l++;
//         }
        
//         return res;
//     }
// }