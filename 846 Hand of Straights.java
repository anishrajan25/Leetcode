class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if(W==0 || hand.length%W!=0) return false;
        HashMap<Integer,Integer> hm=new HashMap<>();
        Arrays.sort(hand);
        for (int x : hand)
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        for (int x : hand)
        {
            if (hm.get(x) == 0)
                continue;
            hm.put(x, hm.get(x) - 1);
            for (int i = 1; i < W; i++)
            {
                if (hm.getOrDefault(x + i, 0) == 0)
                    return false;
                hm.put(x + i, hm.get(x + i) - 1);
            }
        }
        return true;
    }
}