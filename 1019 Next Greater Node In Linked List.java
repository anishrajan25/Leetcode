// https://leetcode.com/problems/next-greater-node-in-linked-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> A = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next)
            A.add(node.val);
        int[] res = new int[A.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.size(); ++i) {
            while (!stack.isEmpty() && A.get(stack.peek()) < A.get(i))
                res[stack.pop()] = A.get(i);
            stack.push(i);
        }
        return res;
    }
}


// class Solution {
    
//     class NodeInfo {
//         int val;
//         int ind;
        
//         NodeInfo(int v, int i) {
//             this.val = v;
//             this.ind = i;
//         }
//     }
    
//     public int[] nextLargerNodes(ListNode head) {
//         Stack<NodeInfo> st = new Stack();
        
//         ListNode tmp = head;
//         int len = 0;
//         while(tmp != null) {
//             tmp = tmp.next;
//             len++;
//         }
        
//         int ans[] = new int[len];
//         tmp = head;
//         for(int i = 0; tmp!=null; tmp = tmp.next, ++i) {
//             while(!st.isEmpty() && st.peek().val < tmp.val) {
//                 ans[st.pop().ind] = tmp.val;
//             }
            
//             st.push(new NodeInfo(tmp.val, i));
//         }
        
//         return ans;
//     }
// }