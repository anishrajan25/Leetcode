// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

class Solution {
    public String minRemoveToMakeValid(String s) {
       char[] ch = s.toCharArray(); 
        int n = ch.length;
        int balance = 0;
        for(int i = 0; i < ch.length; i++){
            if(ch[i] == '(')
                balance++;
            else if(ch[i] == ')'){
                if(balance == 0)
                    ch[i] = '*'; 
                else
                    balance--;
            }
        }
        
        for(int i = ch.length-1;i >=0 ; i--) {
            if(balance > 0 && ch[i] == '('){
                balance--;
                ch[i] = '*';
            }
        }
        
        int b=0;
        for (int i=0;i<n;i++) {
            if (ch[i]!='*')
                ch[b++]=ch[i]; 
        }
        
        return new String(ch).substring(0, b);
        
    }
}

// class Solution {
//     public String minRemoveToMakeValid(String s) {
//         Stack<Character> st = new Stack();
        
//         StringBuilder sb = new StringBuilder();
//         char[] cs = s.toCharArray();
//         for(int i = 0; i < cs.length; ++i) {
//             char c = cs[i];
//             if(c == ')') {
//                 if(st.isEmpty()) continue;
//                 st.pop();
//             }
//             else if(c == '(') st.push(c);
//             sb.append(c);
//         }
        
//         for(int i = sb.length() - 1; !st.isEmpty() && i > -1; i--) {
//             if(sb.charAt(i) == '(') {
//                 sb.deleteCharAt(i);
//                 st.pop();
//             }
//         }
        
//         return sb.toString();
//     }
// }