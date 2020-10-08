class Solution {
    public int numberOfSteps (int num) {
     int i = 0;
        while(num != 0){
            if(num % 2 == 0){
                num /= 2;
                i++;
            }
            if(num % 2 == 1){
               num -= 1;
               i++;
            }
                
        }
        return i;
    }
}