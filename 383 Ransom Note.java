class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) return false;
        int[] chars = new int[26];
        int x = 0;
        for (char c: ransomNote.toCharArray())
        {
            int index = c - 'a';
            if (chars[index] == 0) x++;
            chars[index]++;
        }
        
        for (char c: magazine.toCharArray())
        {
            int index = c - 'a';
            if (chars[index] == 1) x--;
            if (x == 0) return true;
            chars[index]--;
        }
        
        return x == 0;
    }
}