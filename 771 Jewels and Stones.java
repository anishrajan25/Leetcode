import java.util.regex.*;
class Solution {
    public int numJewelsInStones(String J, String S) {
        int c=0;
        for(char x: S.toCharArray())
            for(char y : J.toCharArray())
                if(x==y){
                    c++;
                    break;
                }
        return c;
    }
}