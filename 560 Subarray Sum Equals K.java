class Solution {
    public int subarraySum(int[] nums, int k) {
        int c=0,s=0;
        Map<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            s+=nums[i];
            if(hm.containsKey(s-k))
                c+=hm.get(s-k);
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        return c;
    }
}