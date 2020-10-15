// https://leetcode.com/problems/number-of-recent-calls/https://leetcode.com/problems/number-of-recent-calls/

class RecentCounter {
    LinkedList<Integer> timeline;
    public RecentCounter() {
        timeline = new LinkedList<Integer>();
    }
    
    public int ping(int t) {
        timeline.add(t);
        
        while(timeline.size() > 0) {
            if(t - 3000 > timeline.getFirst()) timeline.removeFirst();
            else break;
        }
        
        return timeline.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */