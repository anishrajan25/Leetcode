// https://leetcode.com/problems/range-sum-query-mutable/

class NumArray {
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public void update(int i, int val) {
        this.nums[i] = val;
    }
    
    public int sumRange(int i, int j) {
        int s = 0;
        for(i = i; i <= j; s += nums[i++]);
        return s;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */