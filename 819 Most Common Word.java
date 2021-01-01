// https://leetcode.com/problems/most-common-word/

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> hm = new HashMap();
        for(String x: banned) hm.put(x, Integer.MIN_VALUE);
        String[] words = paragraph.split("\\s+|,\\s*|\\.\\s*|\\!\\s*|\\'\\s*|\\?\\s*|;\\s*");
        // System.out.println(Arrays.toString(words));
        for(String x: words) {
            String l = x.toLowerCase();
            hm.put(l, hm.getOrDefault(l, 0) + 1);
        }
        int m = 0;
        String res = new String();
        for(String x: hm.keySet()) {
            if(hm.get(x) > m) {
                m = hm.get(x);
                res = x;
            }
        }
        return res;
    }
}