// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1.length == 0 || nums2.length == 0 || k <= 0) return new ArrayList<List<Integer>>();
        PriorityQueue<int[]> heap = new PriorityQueue(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (a[0] + a[1]) - (b[0] + b[1]);
            }
        });
        
        for(int x: nums1)
            for(int y: nums2)
                heap.add(new int[]{x, y});
        
        LinkedList<List<Integer>> res = new LinkedList();
        k = Math.min(nums1.length * nums2.length, k);
        for(int i = 0; i < k; i++) {
            int[] t = heap.poll();
            ArrayList<Integer> tmp = new ArrayList();
            tmp.add(t[0]);
            tmp.add(t[1]);
            res.add(tmp);
        }
            
        
        return res;
    }
}