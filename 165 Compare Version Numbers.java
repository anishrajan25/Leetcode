// https://leetcode.com/problems/compare-version-numbers/

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        
        int first = 0, second = 0;
        
        while(first < ver1.length || second < ver2.length){
            int val1 = first < ver1.length ? Integer.valueOf(ver1[first]) : 0;
            int val2 = second < ver2.length ? Integer.valueOf(ver2[first]) : 0;
            
            if(val1 > val2){
                return 1;
            }else if(val2 > val1){
                return -1;
            }else{
                first++;
                second++;
            }
        }

        return 0;

    }
}