// https://leetcode.com/problems/occurrences-after-bigram/

class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] ip = text.split(" ");
        int[] ind = new int[ip.length];
        int k = 0;
        for(int i = 0; i < ip.length - 2; ++i) {
            if(ip[i].equals(first) && ip[i+1].equals(second)) ind[k++] = i+2;
        }
        String[] op = new String[k];
        for(int i = 0; i < k; op[i] = ip[ind[i++]]);
        return op;
    }
}