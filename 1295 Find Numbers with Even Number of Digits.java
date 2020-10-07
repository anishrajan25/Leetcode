class Solution {
    public int findNumbers(int[] nums) {
        int c=0;
        for(int i: nums)
            if(String.valueOf(i).length()%2==0)
                c++;
        return c;
    }
}