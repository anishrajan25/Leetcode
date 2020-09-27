class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image.length==0 || image[sr][sc]==newColor) return image;
        helper(image,sr,sc,image[sr][sc],newColor);
        return image;
    }
    private void helper(int[][] img, int r, int c, int p, int n) {
        if(r<0 || c<0 || r>=img.length || c>=img[0].length || img[r][c]!=p) return;
        if (img[r][c]==p) img[r][c]=n;
        helper(img, r+1, c, p, n);
        helper(img, r-1, c, p, n);
        helper(img, r, c+1, p, n);
        helper(img, r, c-1, p, n);
    }
}