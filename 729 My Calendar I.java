//   https://leetcode.com/problems/my-calendar-i/

class MyCalendar {
    class TreeNode {
        int start;
        int end;
        TreeNode right;
        TreeNode left;
        public TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            right = null;
            left = null;
        }
        public boolean insert(TreeNode n) {
            if (n.end <= start) {
                if (left == null) {
                    left = n;
                    return true;
                }
                return left.insert(n);
            } else if (n.start >= this.end) {
                if (right == null) {
                    right = n;
                    return true;
                }
                return right.insert(n);
            } else {
                return false;
            }     
        }
    }
    
    TreeNode root;
    public MyCalendar() {
        root = null;
         
    }
    public boolean book(int start, int end) {
        if (root == null) {
            root = new TreeNode(start, end);
            return true;
        } else {
            return root.insert(new TreeNode(start, end));
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */


// class MyCalendar {
//     TreeMap<Integer, Integer> calendar;

//     MyCalendar() {
//         calendar = new TreeMap();
//     }

//     public boolean book(int start, int end) {
//         Integer prev = calendar.floorKey(start),
//                 next = calendar.ceilingKey(start);
//         if ((prev == null || calendar.get(prev) <= start) &&
//                 (next == null || end <= next)) {
//             calendar.put(start, end);
//             return true;
//         }
//         return false;
//     }
// }