// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/


int countNegatives(int** grid, int gridSize, int* gridColSize){
    int res = 0;
    for(int i = 0; i < gridSize; ++i) {
        int l = 0, h = *gridColSize - 1;
        while(l < h) {
            int m = l + (h - l)/2;
            if(grid[i][m] < 0) h = m;
            else l = m + 1;
        }
        if(grid[i][l] > -1) continue;
        res += *gridColSize - l;
    }
    
    
    return res;
}



// int countNegatives(int** grid, int gridSize, int* gridColSize){
//     int cnt=0;
    
//     for(int i=0;i<gridSize;i++)
//     {
//         for(int j=0;j<*gridColSize;j++)
//         {
//             if(grid[i][j]<0)
//                 cnt++;
//         }
//     }
//     return cnt;
// }