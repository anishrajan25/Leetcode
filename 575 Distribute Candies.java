// https://leetcode.com/problems/distribute-candies/

class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> s = new HashSet();
        for(int i: candies) s.add(i);
        return Math.min(candies.length / 2, s.size());
    }
}