class MinStack {

    /** initialize your data structure here. */
    Node head;
    int min;
    public MinStack() {
        head=null;
        min=Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        Node n=new Node(x);
        if(x<=min)
        {
            Node t=new Node(min);
            t.next=head;
            head=t;
            min=x;
        }
        n.next=head;
        head=n;
    }
    
    public void pop() {
        if(head==null)
            return;
        if(this.top()==min)
        {
            min=head.next.data;
            head=head.next;
        }
        head=head.next;
    }
    
    public int top() {
        return head.data;
    }
    
    public int getMin() {
        return min;
    }
}
class Node
{
    int data;
    Node next;
    Node()
    {
        data=0;
        next=null;
    }
    Node(int d)
    {
        data=d;
        next=null;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */