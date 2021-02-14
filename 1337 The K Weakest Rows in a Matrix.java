// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
        int max = -1;
        for(int i = 0; i < mat.length; i++) {
            int c = 0;
            for(int j = 0; j < mat[i].length; j++) c += mat[i][j];
            hm.putIfAbsent(c, new ArrayList<Integer>());
            hm.get(c).add(i);
            max = Math.max(max, c);
        }
        
        int res[] = new int[k];
        int x = 0;
        
        for(int i = 0; i <= max && x < k; i++) {
            if(!hm.containsKey(i)) continue;
            for(int ind: hm.get(i)) {
                res[x++] = ind;
                if(x == k) break;
            }
        }
        
        return res;
    }
}
