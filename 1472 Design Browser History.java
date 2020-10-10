// https://leetcode.com/problems/design-browser-history/


class BrowserHistory {

    private int current = 0;
    private int end = 0;
    // according to constraint
    private String[] history = new String[101];
    
    public BrowserHistory(String homepage) {
        history[0] = homepage;
    }
    
    public void visit(String url) {
        current++;
        end = current;
        history[current] = url;
    }
    
    public String back(int steps) {
        // avoiding negative values
        current = Math.max(0, current - steps);
        return history[current];
    }
    
    public String forward(int steps) {
        // avoiding out of bounds
        current = Math.min(current + steps, end);
        return history[current];
    }
}



// class BrowserHistory {
//     class Page{
//         String url;
//         Page next, prev;
        
//         Page(String u, Page p, Page n) {
//             url = new String(u);
//             prev = p;
//             next = n;
//         }
//     }
    
//     Page head, curr;
    
//     public BrowserHistory(String homepage) {
//         head = new Page(homepage, null, null);
//         curr = head;
//     }
    
//     public void visit(String url) {
//         Page p = new Page(url, curr, null);
//         curr.next = p;
//         curr = p;
//     }
    
//     public String back(int steps) {
//         while(curr != head && steps != 0) {
//             curr = curr.prev;
//             steps--;
//         }
        
//         return curr.url;
//     }
    
//     public String forward(int steps) {
//         while(curr.next != null && steps != 0) {
//             curr = curr.next;
//             steps--;
//         }
        
//         return curr.url;
//     }
// }

// /**
//  * Your BrowserHistory object will be instantiated and called as such:
//  * BrowserHistory obj = new BrowserHistory(homepage);
//  * obj.visit(url);
//  * String param_2 = obj.back(steps);
//  * String param_3 = obj.forward(steps);
//  */