class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        dp[text1.length()-1][text2.length()-1]=text1.charAt(text1.length()-1)==text2.charAt(text2.length()-1)?1:0;
        for(int i=text1.length()-2;i>=0;i--)
            if(text2.charAt(text2.length()-1)==text1.charAt(i))
                dp[i][text2.length()-1]=1;
            else
                dp[i][text2.length()-1]=dp[i+1][text2.length()-1];
        for(int i=text2.length()-2;i>=0;i--)
            if(text1.charAt(text1.length()-1)==text2.charAt(i))
                dp[text1.length()-1][i]=1;
            else
                dp[text1.length()-1][i]=dp[text1.length()-1][i+1];
        for(int i=text2.length()-2;i>=0;i--) {
            for(int j=text1.length()-2;j>=0;j--) {
                dp[j][i]=(text1.charAt(j)==text2.charAt(i)) ? dp[j][i]=dp[j+1][i+1]+1 : Math.max(dp[j+1][i],dp[j][i+1]);
            }
        }
        return dp[0][0];
    }
}