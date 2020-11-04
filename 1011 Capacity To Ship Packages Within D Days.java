// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int right = 0, left = 0;
        for (int weight : weights) {
            right += weight;
            left = Math.max(left, weight);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (!isPossible(weights, D, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    public boolean isPossible(int[] weights, int D, int k) {
        int d = 1;
        int sum = 0;
        for (int weight : weights) {
            if (sum + weight > k) {
                sum = 0;
                d++;
            }
            sum += weight;
        }
        return d <= D;
    }
}