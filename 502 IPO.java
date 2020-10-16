// https://leetcode.com/problems/ipo/

class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        
        LinkedList<int[]> lst = new LinkedList();
        for(int i=0; i<Profits.length; i++){
            lst.add(new int[]{Capital[i], Profits[i]});
        }
        
        Collections.sort(lst, (a,b)-> b[1]-a[1]); // sort descending
        
        while(k > 0){
            boolean found = false;
            for(int i=0; i<lst.size(); i++){
                int c = lst.get(i)[0];
                if(W >= c){
                    int[] removed = lst.remove(i);
                    W += removed[1];
                    k--;
                    found = true;
                    break;
                }
            }
            if(!found) break;
        }
        return W;
    }
}

// class Solution {
//     public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        
//         k = Math.min(k, Profits.length);
//         TreeMap<Integer, PriorityQueue<Integer>> tm = new TreeMap((a,b) -> (int)b - (int)a);
        
//         for(int i = 0; i < Profits.length; i++) {
//             if(!tm.containsKey(Profits[i])) {
//                 PriorityQueue<Integer> p = new PriorityQueue<Integer>();
//                 p.add(Capital[i]);
//                 tm.put(Profits[i], p);
//             }
//             else {
//                 tm.get(Profits[i]).add(Capital[i]);
//             }
//         }
        
//         while(k > 0) {
//             boolean found = false;
//             for(Integer i: tm.keySet()) {
//                 if(W >= tm.get(i).peek()) {
//                     int x = tm.get(i).poll();
//                     W += i;
//                     found = true;
//                     if(tm.get(i).size() == 0) tm.remove(i);
//                     k--;
//                     break;
//                 }
//             }
//             if(!found) return W;
//         }
        
//         return W;
//     }
// }