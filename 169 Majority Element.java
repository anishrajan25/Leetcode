class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hm= new HashMap<>();
        for(int x: nums)
        {
            if(hm.containsKey(x))
            {
                int i=hm.get(x);
                if(i+1>nums.length/2)
                    return x;
                hm.put(x,i+1);
            }
            else
                hm.put(x,1);
        }
        return nums[0];
    }
}