// https://leetcode.com/problems/reorder-data-in-log-files/

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        int di = logs.length - 1;
        for(int i = di; i >= 0; --i) {
            String x = logs[i];
            if(Character.isDigit(x.charAt(x.indexOf(" ") + 1))) {
                logs[i] = logs[di];
                logs[di--] = x;
            }
        }
        
        Arrays.parallelSort(logs, 0, di + 1, new Comparator<String>() {
            public int compare(String a, String b) {
                int ai = a.indexOf(" "), bi = b.indexOf(" ");
                int d = a.substring(ai + 1).compareTo(b.substring(bi + 1));
                return d == 0 ? a.substring(0, ai).compareTo(b.substring(0, bi)) : d;
            }
            
        });
        
        return logs;
    }
}