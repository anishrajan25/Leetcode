// https://leetcode.com/problems/simplify-path/

class Solution {
    public String simplifyPath(String path) {
        String[] dir = path.split("/");
        LinkedList<String> st = new LinkedList();
        
        for(String x: dir) {
            if(x.equals("..")) {if(st.size() > 0) st.removeLast();}
            else if(x.equals(".") || x.length() == 0) continue;
            else st.addLast(x);
        }
        
        StringBuilder finalPath = new StringBuilder();
        
        for(String x: st) finalPath.append("/").append(x);
        if(finalPath.length() == 0) return "/";
        return finalPath.toString();
    }
}
