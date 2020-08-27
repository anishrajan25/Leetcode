class Solution {
    public void rotate(int[][] arr) {
        if(arr.length==0) return;
        int x=arr.length-1;
        for(int i=0;i<arr.length/2;i++)
        {
            for(int j=i;j<x-i;j++)
            {
                int t=arr[i][j];
                arr[i][j]=arr[x-j][i];
                arr[x-j][i]=arr[x-i][x-j];
                arr[x-i][x-j]=arr[j][x-i];
                arr[j][x-i]=t;
            }
        }
    }
}