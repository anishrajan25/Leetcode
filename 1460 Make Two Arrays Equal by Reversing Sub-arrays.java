// https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) return false;
        int[] freq = new int[1001];
        
        for (int i = 0; i<target.length; ++i) {
            freq[target[i]]++;
            freq[arr[i]]--;
        }
        
        for (int n : freq)  if (n != 0) return false;
        
        return true;
    }
}


// class Solution {
//     public boolean canBeEqual(int[] target, int[] arr) {
//         if(target.length != arr.length) return false;
        
//         HashMap<Integer, Integer> hm = new HashMap<>();
        
//         for(int i = 0; i < arr.length; ++i) {
//             hm.put(target[i], hm.getOrDefault(target[i], 0) + 1);
//             hm.put(arr[i], hm.getOrDefault(arr[i], 0) - 1);
//         }
        
//         for(int i : hm.values()) if(i != 0) return false;
        
//         return true;
//     }
// }