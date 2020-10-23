// https://leetcode.com/problems/4sum/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int T) {
        List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        if(nums == null || nums.length == 0) return ans;
        
        final int N = nums.length;
        
        Arrays.sort(nums);
        
        for(int i = 0; i < N - 3; ++i) {
            if(i > 0 && nums[i - 1] == nums[i]) continue;
            for(int l = N - 1; l > i + 2; --l ) {
                if(l < N - 1 && nums[l + 1] == nums[l]) continue;
                
                int lo = i + 1, hi = l - 1;
                
                int target = T - nums[i] - nums[l];
                if(nums[lo] + nums[lo + 1] > target) continue; // min possible
                if(nums[hi] + nums[hi - 1] < target) break; // max possible
                while(lo < hi){
                    int sum = nums[lo] + nums[hi];
                    if(sum == target){
                        ans.add(Arrays.asList(nums[i], nums[lo], nums[hi], nums[l]));

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
        }
        
        return ans;
    }
}



//   for general kSum

// public List<List<Integer>> fourSum(int[] nums, int target) {
//     Arrays.sort(nums);
//     return kSum(nums, target, 0, 4);
// }
// public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
//     List<List<Integer>> res = new ArrayList<>();
//     if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k)
//         return res;
//     if (k == 2)
//         return twoSum(nums, target, start);
//     for (int i = start; i < nums.length; ++i)
//         if (i == start || nums[i - 1] != nums[i])
//             for (var set : kSum(nums, target - nums[i], i + 1, k - 1)) {
//                 res.add(new ArrayList<>(Arrays.asList(nums[i])));
//                 res.get(res.size() - 1).addAll(set);
//             }
//     return res;
// }
// public List<List<Integer>> twoSum(int[] nums, int target, int start) {
//     List<List<Integer>> res = new ArrayList<>();
//     int lo = start, hi = nums.length - 1;
//     while (lo < hi) {
//         int sum = nums[lo] + nums[hi];
//         if (sum < target || (lo > start && nums[lo] == nums[lo - 1]))
//             ++lo;
//         else if (sum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1]))
//             --hi;
//         else
//             res.add(Arrays.asList(nums[lo++], nums[hi--]));
//     }
//     return res;
// }