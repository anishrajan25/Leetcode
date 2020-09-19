// https://leetcode.com/problems/bulls-and-cows/

// Slower solution using hash map
// class Solution {
//     public String getHint(String secret, String guess) {
//         int b = 0, c = 0;
//         HashMap<Character, Integer> hm = new HashMap<>();
//         for(int i = 0; i < secret.length(); ++i) {
            
//         }
//         for(int i = 0; i < secret.length(); ++i) {
//             char s = secret.charAt(i), g = guess.charAt(i);
//             if(s == g)
//                 b++;
//             else {
//                 if(hm.getOrDefault(s, 0) < 0)
//                     c++;
//                 hm.put(s, hm.getOrDefault(s, 0) + 1);
//                 if(hm.getOrDefault(g, 0) > 0)
//                     c++;
//                 hm.put(g, hm.getOrDefault(g, 0) - 1);
//             }
//         }
        
//         return "" + b + "A" + c + "B";
//     }
// }

class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] numbers = new int[10];
        for(int i = 0; i < guess.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if(s == g) bulls++;
            else {
                if(numbers[s]++ < 0) cows++;
                if(numbers[g]-- > 0) cows++;
            }
        }
        
        return bulls + "A" + cows + "B";
    }
}