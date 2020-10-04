//  https://leetcode.com/problems/matrix-cells-in-distance-order/  


class Solution {
    class Cell {
        int pos[], dist;
        
        Cell(int x, int y, int d) {
            pos = new int[]{x,y};
            dist = d;
        }
        
        public int getDist() { return dist; }
        
        public int[] getPos() { return pos; }
    }
    
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        ArrayList<Cell> al = new ArrayList();
        int res[][] = new int[R*C][2];
        
        for(int i = 0; i<R; ++i) {
            for(int j = 0; j<C; ++j) {
                al.add(new Cell(i, j, Math.abs(r0 - i) + Math.abs(c0 - j)));
            }
        }
        
        Collections.sort(al, new Comparator<Cell>() {
           @Override
            public int compare(Cell o1, Cell o2) {
                return o1.getDist() - o2.getDist();
            }
        });
        
        for(int i = 0; i < R*C; ++i) {
            res[i] = al.get(i).getPos();
        }
        
        return res;
    }
}