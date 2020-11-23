// https://leetcode.com/problems/video-stitching/

class Solution {
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
            }
        });
        
        if(clips[0][0] != 0) return -1;
        int i = 0, c = 1;
        while(clips[i + 1][0] == 0) i++;
        if(clips[i][1] >= T) return c;
        int m = Integer.MIN_VALUE;
        while(i < clips.length) {
            int x = i;
            while(i < clips.length - 1 && clips[i][1] >= clips[i + 1][0]) {
                i++;
                m = Math.max(m, clips[i][1]);
            }
            if(x == i) return -1;
            c++;
            if(m >= T) return c;
            i++;
        }
        
        return -1;
    }
}