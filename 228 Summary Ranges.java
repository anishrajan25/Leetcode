// https://leetcode.com/problems/summary-ranges/

class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length == 0) return new ArrayList<String>();
        
        List<String> res = new ArrayList();
        for(int i = 0; i < nums.length; i++) {
            StringBuilder range = new StringBuilder();
            range.append(nums[i]);
            int j = i;
            while(i < nums.length - 1 && nums[i+1] == nums[i] + 1) i++;
            if(i > j) range.append("->").append(nums[i]);
            res.add(range.toString());
        }
        
        return res;
    }
}