// https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/

class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> result = new ArrayList<>();
        int nR = 2; int nC = colsum.length;
        int[][] tmpRes = new int[nR][nC];
        
        for(int i = 0; i < nC; i++){
            if(colsum[i] == 2){
                upper -= 1; lower -= 1;
                tmpRes[0][i] = tmpRes[1][i] = 1;
            }
        }
        if(upper < 0 || lower < 0) return result;
        
        for(int i = 0; i < nC; i++){
            if(colsum[i] == 1){
                if(upper > 0){
                    tmpRes[0][i] = 1;
                    upper -= 1;
                }else if(lower > 0){
                    tmpRes[1][i] = 1;
                    lower -= 1;
                }else{
                    return result;
                }
            }
        }
        if(upper > 0 || lower > 0) return result;
        
        for(int i = 0; i < 2; i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0; j < nC; j++){
                list.add(tmpRes[i][j]);
            }
            result.add(list);
        }
        return result;
    }
}

// class Solution {
//     public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
//         List<List<Integer>> res = new ArrayList();
//         int[] r = new int[colsum.length];
//         for(int i = 0; i < 2; ++i) {
//             for(int j = 0; j < colsum.length; j++) {
//                 if(upper > 0 && r[j] == 0 && colsum[j] == 2 - i) {
//                     r[j] = 1;
//                     colsum[j]--;
//                     upper--;
//                 }
//             }
//         }
//         List<Integer> row = new ArrayList();
//         for(int i = 0; i < colsum.length; ++i) {
//             row.add(r[i]);
//         }
//         res.add(row);
//         r = new int[colsum.length];
//         for(int j = 0; j < colsum.length; j++) {
//             if(lower > 0 && r[j] == 0 && colsum[j] == 1) {
//                 r[j] = 1;
//                 colsum[j]--;
//                 lower--;
//             }
//         }
//         row = new ArrayList();
//         for(int i = 0; i < colsum.length; ++i) {
//             row.add(r[i]);
//         }
//         res.add(row);
//         if((lower + upper) != 0 || !Arrays.equals(colsum, new int[colsum.length])) return new ArrayList();
//         return res;
//     }
// }