// https://leetcode.com/problems/parsing-a-boolean-expression/

class Solution {
    char[] exp;
    int p;
    public boolean parseBoolExpr(String expression) {
        exp = expression.toCharArray();
        p = 0;
        return eval();
    }
    
    private boolean eval() {
        char c = exp[p++];
        
        if(c == 't' || c == 'f') return c =='t';
        else {
            p++;
            boolean temp = eval();
            if(c == '!') {
                p++;
                return !temp;
            }
            else {
                while(exp[p++] != ')') {
                    if(c == '&') temp &= eval();
                    else temp |= eval();
                }
                return temp;
            }
        }
    }
}


//       4ms beat 62.55% stack (pre-order eval approach)
// class Solution {
//     public boolean parseBoolExpr(String expression) {
//         char[] st = new char[expression.length()];
//         int p = 0;
//         boolean temp;
//         char[] exp = expression.toCharArray();
//         for(int i = exp.length-1; i > -1; --i) {
//             if(exp[i] == ',') continue;
//             if(exp[i] == '(') {
//                 switch(exp[--i]) {
//                     case '!':
//                         temp = !(st[--p] == 't');
//                         --p;
//                         st[p++] = temp ? 't' : 'f';
//                         break;
//                     case '&':
//                         temp = st[--p] == 't';
//                         while(p > 0 && st[p-1] != ')') temp &= st[--p] == 't';
//                         --p;
//                         st[p++] = temp ? 't' : 'f';
//                         break;
//                     case '|':
//                         temp = st[--p] == 't';
//                         while(p > 0 && st[p-1] != ')') temp |= st[--p] == 't';
//                         --p;
//                         st[p++] = temp ? 't' : 'f';
//                         break;
//                     default:
//                         st[p++] = exp[i];
//                         break;
//                 }
//             }
//             else st[p++] = exp[i];
//         }
        
//         return st[--p] == 't';
//     }
// }