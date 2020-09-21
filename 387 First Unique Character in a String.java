class Solution {
    public int firstUniqChar(String s) {
        for(int i=0;i<s.length();i++){
            int x=s.indexOf(s.charAt(i));
            if(-1==s.indexOf(s.charAt(i),x+1))
                return i;
        }
        return -1;
    }
}