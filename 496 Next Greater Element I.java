// https://leetcode.com/problems/next-greater-element-i/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums2.length; i++) hm.put(nums2[i], i);
        for(int i = 0; i < nums1.length; i++) {
            int j = hm.get(nums1[i]) + 1;
            while(j < nums2.length && nums2[j] <= nums1[i]) j++;
            nums1[i] = j == nums2.length ? -1 : nums2[j];
        }
        
        return nums1;
    }
}