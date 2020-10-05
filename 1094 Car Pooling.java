// https://leetcode.com/problems/car-pooling/


class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] time = new int[1001];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int[] arr: trips) {
            time[arr[1]] += arr[0];
            time[arr[2]] -= arr[0];
            min = Math.min(min, arr[1]);
            max = Math.max(max, arr[2]);
        }
        
        for(int i = min ; i<= max;i++) {
            capacity -= time[i];
            if(capacity < 0)
               return false;
        }
        return true;
    }
}


//  O(N)
// class Solution {
//     public boolean carPooling(int[][] trips, int capacity) {
//         Map<Integer, Integer> map = new TreeMap<>();
//         for (int[] trip : trips) {
//             map.put(trip[1], map.getOrDefault(trip[1], 0) + trip[0]);
//             map.put(trip[2], map.getOrDefault(trip[2], 0) - trip[0]);
//         }
        
//         for (int p : map.values()) {
//             capacity -= p;
//             if (capacity < 0) return false;
//         }
        
//         return true;
//     }
// }

//    O(NlogN)
// class Solution {
//     public boolean carPooling(int[][] trips, int capacity) {
//         if(trips == null || trips.length == 0) return true;
//         if(trips.length == 1) return trips[0][1] <= capacity;
        
//         Arrays.sort(trips, new Comparator<int[]>() {
//             public int compare(int f[], int s[]) {return f[1] - s[1];} 
//         });
        
//         int drop[][] = new int[trips.length][3];
        
//         for(int i = 0; i < trips.length; ++i) drop[i] = Arrays.copyOf(trips[i], 3);
        
//         Arrays.sort(drop, new Comparator<int[]>() {
//             public int compare(int f[], int s[]) {return f[2] - s[2];} 
//         });
        
//         if(trips[0][1] > capacity) return false;
        
//         int cap = capacity - trips[0][0], k = 0;
        
//         for(int i = 1; i < trips.length; ++i) {
//             while(k < i && drop[k][2] <= trips[i][1]) cap += drop[k++][0];
//             cap -= trips[i][0];
//             if(cap < 0) return false;
//         }
        
//         return cap >= 0;
//     }
// }