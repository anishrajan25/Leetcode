class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0) return new ArrayList();
        Map<String,List> m=new HashMap<>();
        for(String x : strs)
        {
            char[] c=x.toCharArray();
            Arrays.sort(c);
            String k=String.valueOf(c);
            if(!m.containsKey(k)) m.put(k,new ArrayList());
            m.get(k).add(x);
        }
        return new ArrayList(m.values());
    }
}