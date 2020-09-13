// https://leetcode.com/problems/3sum/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        if(nums == null || nums.length == 0) return ans;
        
        final int N = nums.length;
        
        Arrays.sort(nums);
        
        for(int i = 0; i < N - 2; ++i){
            if(i > 0 && nums[i - 1] == nums[i]) continue;
            int lo = i + 1, hi = N - 1;
            
            int target = -nums[i];
            
            while(lo < hi){
                int sum = nums[lo] + nums[hi];
                if(sum == target){
                    ans.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    
                    ++lo;
                    --hi;
                    
                    while(lo < hi && nums[lo - 1] == nums[lo]) ++lo;
                    while(lo < hi && nums[hi] == nums[hi + 1]) --hi;
                }else if(sum > target){
                    --hi;
                }else{
                    ++lo;
                }
            }
        }
        
        return ans;
    }
}

// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         if (nums.length < 3) return new ArrayList<>(); // if nums less than 3 element
//         Arrays.sort(nums); // sort array
//         Set<List<Integer>> sum3 = new HashSet<>();
//         for(int i = 0; i < nums.length - 2; ++i) {
//             int l = i + 1;
//             int r = nums.length - 1;
//             while(l < r)  {
//                 int sum = nums[i] + nums[l] + nums[r];
//                 if(sum == 0)
//                     sum3.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
//                 else if(sum < 0) l++;
//                 else r--;
//             }
//         }
//         return new ArrayList(sum3);
//     }
// }