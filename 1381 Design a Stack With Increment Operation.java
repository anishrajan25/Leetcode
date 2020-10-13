// https://leetcode.com/problems/design-a-stack-with-increment-operation/

class CustomStack {
    int[] stack;
    int p;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        p = -1;
    }
    
    public void push(int x) {
        if(p < stack.length - 1) stack[++p] = x;
    }
    
    public int pop() {
        if(p == -1) return -1;
        return stack[p--];
    }
    
    public void increment(int k, int val) {
        for(int i = 0; i < k && i <= p; stack[i++] += val);
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */