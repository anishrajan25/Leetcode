// https://leetcode.com/problems/fruit-into-baskets/

class Solution {
    public int totalFruit(int[] tree) {
        int res = 0, f = -1, s = -1, t = 0;
        for(int i = 0; i < tree.length; i++) {
            if(tree[i] == f || tree[i] == s) continue;
            else if(f == -1) f = tree[i];
            else if(s == -1) s = tree[i];
            else {
                res = Math.max(res, i - t);
                f = tree[i - 1];
                s = tree[i];
                t = i - 1;
                while(t > -1 && tree[t] == f) t--;
                t++;
            }
        }
        
        return Math.max(res, tree.length - t);
    }
}