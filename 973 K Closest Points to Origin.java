// https://leetcode.com/problems/k-closest-points-to-origin/



class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int N = points.length;
        int[] dists = new int[N];
        for (int i = 0; i < N; ++i)
            dists[i] = dist(points[i]);

        Arrays.sort(dists);
        int distK = dists[K-1];

        int[][] ans = new int[K][2];
        int t = 0;
        for (int i = 0; i < N; ++i)
            if (dist(points[i]) <= distK)
                ans[t++] = points[i];
        return ans;
    }

    public int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}



// class Solution {
//     public int[][] kClosest(int[][] points, int K) {
//         Arrays.sort(points, new Comparator<int[]>() {
//            public int compare(int[] o1, int[] o2) {
//                return (o1[0] * o1[0] + o1[1] * o1[1]) - (o2[0] * o2[0] + o2[1] * o2[1]);
//            }
//         });
        
//         return Arrays.copyOfRange(points, 0, K);
//     }
// }