// https://leetcode.com/problems/different-ways-to-add-parentheses/

class Solution {
    HashMap<String, List<Integer>> hm = new HashMap();
    
    public List<Integer> diffWaysToCompute(String input) {
        if(hm.containsKey(input)) return hm.get(input);
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        for(int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            
            if(c == '+' || c == '*' || c == '-') {
                List<Integer> l= diffWaysToCompute(input.substring(0, i));
                List<Integer> r= diffWaysToCompute(input.substring(i + 1));
                for(int op1: l) {
                    for(int op2: r) {
                        if (c == '+') {
                            res.add(op1 + op2);
                        } else if (c == '-') {
                            res.add(op1 - op2);
                        } else {
                            res.add(op1 * op2);
                        }
                    }
                }
            }
        }
        if(res.isEmpty()) res.add(Integer.valueOf(input));
        hm.put(input, res);
        return res;
    }
}