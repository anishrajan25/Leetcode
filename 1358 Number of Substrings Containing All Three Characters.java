// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

class Solution {
    public int numberOfSubstrings(String s) {
        // first we find smallest substring with all 3 chars
        // then with this substring we can form n - j(i.e. number of chars to right of this substring)
        // number of substrings
        // then we move the beginning of this substring to right by 1
        // if this resulting substring doesn't contain all chars then, 
        // we move the end of the substring to the right untill and unless we find a substring containing
        // all chars and then repeat every  step.
        
        
        int a = 0, b = 0, c = 0, i = 0, j = 0, n = s.length(), ans = 0;
        while(j < n) {
            char x = s.charAt(j);
            if(x == 'a') ++a;
            else if(x == 'b') ++b;
            else ++c;
            while(a>0 && b>0 && c>0) {
                ans += n - j;
                char y = s.charAt(i++); // extract char and move beginning to right by 1
                if(y == 'a') --a;
                else if(y == 'b') --b;
                else --c;
            }
            j++; // move the end to right by 1
        }
        
        return ans;
    }
}

