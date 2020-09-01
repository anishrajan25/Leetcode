class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        StringBuilder n=new StringBuilder(String.valueOf(x));
        return n==n.reverse();
    }
}