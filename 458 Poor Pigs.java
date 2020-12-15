// https://leetcode.com/problems/poor-pigs/

// class Solution {
//     public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
//         int pigs = 0;
//         while(Math.pow(minutesToTest / minutesToDie + 1, pigs) < buckets) ++pigs;
//         return pigs;
//     }
// }


class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        while(Math.pow(minutesToTest / minutesToDie + 1, pigs) < buckets) ++pigs;
        return pigs;
    }
}


// class Solution {
//     public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
//         int attempts = minutesToTest / minutesToDie;
//         int states = attempts + 1;
//         return (int)Math.ceil(Math.log(buckets) / Math.log(states));
//     }
// }