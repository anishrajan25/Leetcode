// https://leetcode.com/problems/diagonal-traverse-ii/

class Solution {
    class Point {
        int row;
        int sum;
        int val;
        Point(int row,int sum,int val) {
            this.row = row;
            this.sum = sum;
            this.val = val;
        }
        
    }
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        ArrayList<Point> list = new ArrayList<>();
        for(int r = 0;r<nums.size() ;r++) {
            List<Integer> elements = nums.get(r);
            for(int c =0;c<elements.size();c++) {
                list.add(new Point(r,r+c,elements.get(c)));
            }
        }
        Collections.sort(list,(o1,o2) -> {
           int result = Integer.compare(o1.sum, o2.sum);
            if(result == 0) return Integer.compare(o2.row,o1.row);
            return result;
        });
        int total = list.size();
        int[] solution = new int[total];
        for(int i=0;i<total;i++) {
            solution[i] = list.get(i).val;
        }
        return solution;
    }
}

// class Solution {
//     public int[] findDiagonalOrder(List<List<Integer>> nums) {
//         if(nums == null || nums.size() == 0) return new int[0];
//         TreeMap<Integer, ArrayList<Integer>> hm = new TreeMap<>();
//         int s = 0;
//         for(int i = 0; i < nums.size(); i++) {
//             List<Integer> al = nums.get(i);
//             int j = 0;
//             for(int n: al) {
//                 if(!hm.containsKey(i + j)) hm.put(i + j, new ArrayList<Integer>());
//                 hm.get(i + j).add(0, n);
//                 j++;
//                 s++;
//             }
//         }
        
//         int res[] = new int[s], k = 0;
        
//         for(Map.Entry<Integer, ArrayList<Integer>> e: hm.entrySet()) {
//             for(int n: e.getValue()) res[k++] = n;
//         }
        
//         return res;
//     }
// }