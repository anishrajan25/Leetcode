// https://leetcode.com/problems/degree-of-an-array/


class Solution {
    public int findShortestSubArray(int[] nums) {
        int max = 0;
        for(int n : nums){
            if(n > max) max = n;
        }
        int[] firstseen = new int[max+1]; //index: value, value: first-seen location
        int[] count = new int[max+1];
        int degree = 1, res = 1;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            count[num]++;
            if(count[num] == 1)
                firstseen[num] = i;
            if(count[num] > degree){ //update degree
                degree = count[num];
                res = i - firstseen[num] + 1;
            }
            else if(count[num] == degree){
                res = Math.min(res, i-firstseen[num]+1);
            }
        }
        return res;
    }
}


//   ANOTHER SOLUTION
// class Solution {
//     public int findShortestSubArray(int[] nums) {
//         Map<Integer, Integer> left = new HashMap(), right = new HashMap(), count = new HashMap();

//         for (int i = 0; i < nums.length; i++) {
//             int x = nums[i];
//             if (!left.containsKey(x)) left.put(x, i);
//             right.put(x, i);
//             count.put(x, count.getOrDefault(x, 0) + 1);
//         }

//         int ans = nums.length;
//         int degree = Collections.max(count.values());
//         for (int x: count.keySet()) {
//             if (count.get(x) == degree) {
//                 ans = Math.min(ans, right.get(x) - left.get(x) + 1);
//             }
//         }
//         return ans;
//     }
// }
