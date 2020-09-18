class Solution {
    public int maximalSquare(char[][] matrix) {
        int row=matrix.length,col=row>0?matrix[0].length:-1;
        int dp[]=new int[col+1];
        int prev=0,maxlen=0;
        for(int i=1; i<=row; i++) {
            for(int j=1; j<=col; j++) {
                int t=dp[j];
                if(matrix[i-1][j-1]=='1') {
                    dp[j]=Math.min(Math.min(dp[j],prev),dp[j-1])+1;
                    maxlen=Math.max(maxlen,dp[j]);
                }else {
                    dp[j]=0;
                }
                prev=t;
            }
        }
        return maxlen*maxlen;
    }
}