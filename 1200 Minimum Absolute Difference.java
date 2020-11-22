// https://leetcode.com/problems/minimum-absolute-difference/

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int diff = Math.abs(arr[0] - arr[1]);
        List<List<Integer>> res = new ArrayList();
        
        for(int i = 1; i < arr.length - 1; ++i) diff = Math.min(Math.abs(arr[i] - arr[i + 1]), diff);
        for(int i = 0; i < arr.length - 1; ++i) {
            for(int j = i + 1; j < arr.length; ++j) {
                if(Math.abs(arr[i] - arr[j]) == diff) {
                    List<Integer> tmp = new ArrayList();
                    tmp.add(arr[i]);
                    tmp.add(arr[j]);
                    res.add(tmp);
                }
                else break;
            }
        }
        
        return res;
    }
}