class Solution {
    public int myAtoi(String str) {
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right && str.charAt(left) == ' ') {
            left++;
        }
        if (str.isEmpty()) {
            return 0;
        }
        boolean flag = true;
        long result = 0;
        
        if (str.charAt(left) == '-') {
            flag = false;
        }
        else if (str.charAt(left) == '+') {
            flag = true;
        }
        else if (!Character.isDigit(str.charAt(left))) {
            return 0;
        }
        else {
            result = str.charAt(left) - '0';
        }
        
        for (int i = left+1; i <= right; i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                break;
            }
            int digitValue = c - '0';
            result = result*10 + digitValue;
            if (result > Integer.MAX_VALUE)
                return flag ? Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        if(flag)
            return (int)result;
        return (int)result*-1;
    }
}