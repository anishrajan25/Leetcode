class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s=new Stack<Character>(),t=new Stack<Character>();
        int i=0;
        while(i<S.length()){
            if(S.charAt(i)=='#'){
                if(!s.isEmpty())
                    s.pop();
            }
            else s.push(S.charAt(i));
            i++;
        }
        i=0;
        while(i<T.length()){
            if(T.charAt(i)=='#'){
                if(!t.isEmpty())
                    t.pop();
            }
            else t.push(T.charAt(i));
            i++;
        }
        if(s.size()==t.size())
        {
            while(!s.isEmpty() && !t.isEmpty())
                if(s.pop()!=t.pop())
                    return false;
            return true;
        }
        return false;
    }
}