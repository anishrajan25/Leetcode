class Solution {
    public boolean isAnagram(String s, String t) {
        char[] x=s.toCharArray(),y=t.toCharArray();
        Arrays.sort(x);Arrays.sort(y);
        s=new String(x);t= new String(y);
        return s.equals(t);
    }
}