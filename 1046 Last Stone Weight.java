class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
    public int lastStoneWeight(int[] stones) {
        if(stones.length==1)return stones[0];
        for(int i=0;i<stones.length;i++)
        {
            pq.add(stones[i]);
        }
        while(pq.size()!=1)
        {
            int x=pq.poll();
            int y=pq.poll();
            if(y==0)
                return x;
            else
                pq.add(Math.abs(y-x));
        }
        return pq.poll();
    }
}