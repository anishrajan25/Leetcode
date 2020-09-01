class Solution {
    public int maxArea(int[] a) {
        int x,l = 0, r = a.length - 1,mm=Math.min(a[l], a[r]) * (r - l);
        while (l < r) {
            if (a[l] < a[r]) {
                x = l;
                do {
                    l++;
                } while (a[l] < a[x] && l<r);
            } else {
                x = r;
                do {
                    r--;
                } while (a[r] < a[x] && l<r);
            }
            mm = Math.max(Math.min(a[l], a[r]) * (r - l), mm);
        }
        return mm;
    }
}