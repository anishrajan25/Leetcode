// https://leetcode.com/problems/sequential-digits/


// O(log10(high/low) * resultList.length() )
class Solution {
    int div = 1;
    
    private int generateFirst(int beg) {
        if(div == 1000000000) return div+1;
        int num = beg;
        int ans = beg;
        while(ans/div < 1) {
            ++num;
            if(num > 9) {
                div*=10;
                return generateFirst(1);
            }
            ans = ans * 10 + num;
        }
        
        return ans;
    }
    
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<Integer>();
        
        int n = low;
        
        while(n>= 10) {
            n/=10;
            div*=10;
        }
        
        int num = generateFirst(low/div);

        if(num < low) {
            int b = num % div * 10;
            int e = num%10 + 1;
            if(e > 9) {
                div*=10;
                b = generateFirst(1);
                e = 0;
                
            }
            num = b + e;
        }
        
        while(num <= high) {
            res.add(num);
            int b = num % div * 10;
            int e = num%10 + 1;
            if(e > 9) {
                div*=10;
                b = generateFirst(1);
                e = 0;
                
            }
            num = b + e; 
        }
        
        return res;
    }
}



//         ANOTHER SOLUTION
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
        List<Integer> output = new ArrayList<Integer>();
        for(int i=1;i<10;i++){
            int num=0, j =i;
            while(num<=high && j<10){
                 num = num*10+(j);
                if(num>=low && num<=high){
                    output.add(num);
                }
                j++;
            }
        }
        Collections.sort(output);
       return output; 
    }
}