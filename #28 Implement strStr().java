class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0)return 0;
        int i=0,j=0,h=haystack.length(),n=needle.length();
        while(i<=(h-n))
        {
            while(j<n && haystack.charAt(i+j)==needle.charAt(j))
                j++;
            if(j>=n)
                return i;
            j=0;
            i++;
        }
        return -1;
    }
}