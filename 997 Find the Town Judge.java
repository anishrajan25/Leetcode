class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust==null || trust.length==0) return N;
        if(trust.length<N-1) return -1;
        HashMap<Integer,Integer> t=new HashMap<>(),c=new HashMap<>();
        for(int[] a : trust) {
            c.put(a[1],c.getOrDefault(a[1],0)+1);
            t.put(a[0],t.getOrDefault(a[1],0)+1);
        }
        if(c.containsValue(N-1)) {
            int x;
            for (Map.Entry<Integer,Integer> entry : c.entrySet()) {
                if(entry.getValue()==N-1) {
                    if(!t.containsKey(entry.getKey()))
                        return entry.getKey();
                    else
                        return -1;
                }
            }
        }
        return -1;
    }
}