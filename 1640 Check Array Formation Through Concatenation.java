// https://leetcode.com/problems/check-array-formation-through-concatenation/

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < arr.length; i++) hm.put(arr[i], i);
        for(int[] piece: pieces) {
            if(!hm.containsKey(piece[0])) return false;
            int x = hm.get(piece[0]);
            for(int j = 0; j < piece.length; j++) {
                if(!hm.containsKey(piece[j]) || hm.get(piece[j]) != j + x) return false;
            }
        }
        
        return true;
    }
}