// https://leetcode.com/problems/intersection-of-two-arrays/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int k = 0;
        HashSet<Integer> hs = new HashSet(), added = new HashSet();
        addIn(nums1.length < nums2.length ? nums1 : nums2, hs);
        for(int i: nums1.length < nums2.length ? nums2 : nums1) {
            if(hs.contains(i) && !added.contains(i)) {
                nums1[k++] = i;
                added.add(i);    
            }
        }
        
        return Arrays.copyOfRange(nums1, 0, k);
    }
    
    private void addIn(int[] nums, HashSet<Integer> hs) {
        for(int i: nums) hs.add(i);
    }
}