// https://leetcode.com/problems/design-an-ordered-stream/

class OrderedStream {
    String[] os;
    int i;
    public OrderedStream(int n) {
        i = 0;
        os = new String[n];
    }
    
    public List<String> insert(int id, String value) {
        List<String> ret = new ArrayList<String>();
        os[id - 1] = value;
        while(i < os.length && os[i] != null) ret.add(os[i++]);
        return ret;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */