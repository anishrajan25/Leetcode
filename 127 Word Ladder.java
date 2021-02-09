// https://leetcode.com/problems/word-ladder/

class Solution {
    static class Pair {
        String str;
        int t;
        
        Pair(String s, int i) {
            str = s;
            t = i;
        }
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<Pair>();
        Set<String> v = new HashSet();
        Map<String, List<String>> hm = new HashMap();
        
        for(String x: wordList) {
            for(int i = 0; i < beginWord.length(); ++i) {
                String w = x.substring(0, i) + "*" + x.substring(i + 1, beginWord.length());
                List<String> temp = hm.getOrDefault(w, new ArrayList<String>());
                temp.add(x);
                hm.put(w, temp);
            }
        }
        
        q.add(new Pair(beginWord, 1));
        v.add(beginWord);
        while(!q.isEmpty()) {
            Pair p = q.poll();
            String x = p.str;
            int ans = p.t;
            for(int i = 0; i < beginWord.length(); ++i) {
                String w = x.substring(0, i) + "*" + x.substring(i + 1, beginWord.length());
                
                for(String next: hm.getOrDefault(w, new ArrayList<String>())) {
                    if(next.equals(endWord)) return ans + 1;
                    
                    if(!v.contains(next)) {
                        v.add(next);
                        q.add(new Pair(next, ans + 1));
                    }
                }
            }
        }
        
        return 0;
    }
}