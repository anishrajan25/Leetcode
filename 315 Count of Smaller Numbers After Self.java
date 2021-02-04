// https://leetcode.com/problems/count-of-smaller-numbers-after-self/

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        TreeSet<Integer> tm = new TreeSet<>();
        HashMap<Integer, int[]> hm = new HashMap();
        List<Integer> res = new ArrayList<>();
        for(int i = nums.length - 1; i > -1; --i) {
            Integer x = tm.lower(nums[i]);
            if(x != null) {
                int[] tmp = hm.get(x);
                int j = tmp[0] - 1;
                x = tmp[1] + res.get(j - i);
                while(j > i) {
                    if(nums[j] < nums[i]) {
                        x++;
                    }
                    j--;
                }
            }
            else {
                x = 0;
            }
            res.add(0, x);
            int[] data = hm.getOrDefault(nums[i], new int[2]);
            data[0] = i;
            data[1]++;
            hm.put(nums[i], data);
            tm.add(nums[i]);
        }
        return res;
    }
}


// class Solution {
//     public List<Integer> countSmaller(int[] nums) {
//         LinkedList<Integer> res = new LinkedList();
//         for(int i = nums.length - 1; i > -1; --i) {
//             int c = 0;
//             for(int j = i + 1; j < nums.length; j++) {
//                 if(nums[j] < nums[i])
//                     c++;
//             }
//             res.addFirst(c);
//         }
//         return res;
//     }
// }
