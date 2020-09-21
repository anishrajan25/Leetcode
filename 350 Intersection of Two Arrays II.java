class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0,k=0,res[]=new int[nums1.length+nums2.length];
        while(i<nums1.length && j<nums2.length)
        {
            if(nums1[i]==nums2[j])
            {
                res[k++]=nums2[j];
                i++;j++;
            }
            else if(nums1[i]<nums2[j])
                i++;
            else
                j++;
        }
        return Arrays.copyOf(res,k);
    }
}