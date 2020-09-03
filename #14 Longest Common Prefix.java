class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        return longestCommonPrefix(strs,0,strs.length-1);
    }
    private String longestCommonPrefix(String[] strs,int b, int e)
    {
        if(b>=e)
            return strs[b];
        int m=(e+b)/2;
        return common(longestCommonPrefix(strs,b,m) , longestCommonPrefix(strs,m+1,e));
    }
    private String common(String f,String s)
    {
        int i=0,l=Math.min(f.length(),s.length());
        while(i<l && f.charAt(i)==s.charAt(i))
            i++;
        return f.substring(0,i);
    }
}