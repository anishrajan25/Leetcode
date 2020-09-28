// https://leetcode.com/problems/boats-to-save-people/

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        if(people.length  == 1 && people[0] <= limit) return 1;
        Arrays.sort(people);
        int turns = 0;
        int i = 0, j = people.length - 1;
        while(i <= j) {
            if(people[i] + people[j] <= limit) ++i;
            ++turns;
            --j;
        }
        return turns ;
    }
}