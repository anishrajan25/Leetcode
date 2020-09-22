// https://leetcode.com/problems/decode-string/

class Solution {
    public String decodeString(String s) {
        if(s.length() <= 3) return s;
        
        Stack<String> st = new Stack();
        Stack<Integer> rep = new Stack();
        StringBuilder ans = new StringBuilder("");
        
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if(c == ']') {
                StringBuilder temp = new StringBuilder("");
                String x = st.pop();
                while(!st.isEmpty() && !x.equals("[")) {
                    temp.insert(0, x);
                    x = st.pop();
                }
                StringBuilder prod = new StringBuilder("");
                int m = rep.pop();
                while(m > 0) {
                    prod.append(temp);
                    m--;
                }
                if(st.isEmpty()) {
                    ans.append(prod);
                }
                else {
                    st.push(prod.toString());
                }
            }
            else if(Character.isDigit(c)) {
                int num = c - '0';
                while(i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) 
                    num = num * 10 + (int)(s.charAt(++i) - '0');
                rep.push(num);
            }
            else st.push(String.valueOf(c));
        }
        StringBuilder t = new StringBuilder();
        while(!st.isEmpty()) t.insert(0, st.pop());
        ans.append(t);
        return ans.toString();
    }
}