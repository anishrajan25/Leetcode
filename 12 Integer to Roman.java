// https://leetcode.com/problems/integer-to-roman/

class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder builder = new StringBuilder();
        int i = 0;
        
        while (num > 0) {        
            while (num >= values[i]) {
                builder.append(romans[i]);
                num -= values[i];
            }
            
            i++;
        }
        
        return builder.toString();
    }
}


// class Solution {
//     String [] ones = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
    
//     String thousands[] = {"","M","MM","MMM"};
    
//     String hundreds[] = {"","C","CC","CCC","CD","D","DC","DCC", "DCCC", "CM"};
        
//     String tens[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    
//     public String intToRoman(int num) {
//         String ans = "";
//         if(num/1000>0){
//             ans = ans+thousands[num/1000];
//             num=num%1000;
//         }
//         if(num/100>0){
//             ans= ans + hundreds[num/100];
//             num=num%100;
//         }
//         if(num/10>0){
//             ans = ans+tens[num/10];
//             num = num%10;
//         }
//         if(num>0){
//             ans = ans+ones[num];
//         }
//         return ans;
//     }
// }