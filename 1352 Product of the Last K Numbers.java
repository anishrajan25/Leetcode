// https://leetcode.com/problems/product-of-the-last-k-numbers/

class ProductOfNumbers {
    
    private List<Integer> list;

    public ProductOfNumbers() {
        list = new ArrayList<>();
    }
    
    public void add(int num) {
        if(num == 0){
            //reset, we dont need to keep the old ones since their product will be 0 anyways
            list = new ArrayList<>();
        }else{
            //multiply the current one with the last added one and store it
            int size = list.size();
            list.add((size > 0 ? list.get(size - 1) : 1) * num);
        }
    }
    public int getProduct(int k) {
        int size = list.size();
        //this means we encountered atleast one zero already and k is oldest index than the last zero index
        if(k > size)
            return 0;
        //divide the product of all numbers so far with the product of first k - 1 indices
        return list.get(size - 1) / (size - k - 1 >=0 ? list.get(size - k - 1) : 1);
    }
}


/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */