// https://leetcode.com/problems/maximum-binary-string-after-change/

class Solution {
    public String maximumBinaryString(String binary) {
        char[] bin = binary.toCharArray();
        int l = 0;
        while(l < bin.length && bin[l] == '1') l++;
        int z = 0, o = 0;
        for(int i = l; i < bin.length; i++) {
            if(bin[i] == '0') z++;
            else o++;
        }
        Arrays.fill(bin, bin.length - o, bin.length, '1');
        if(z > 0) {
            Arrays.fill(bin, l, l + z - 1, '1');
            bin[l + z - 1] = '0';
        }
        return new String(bin);
    }
}


// class Solution {
//     public String maximumBinaryString(String binary) {
//         char[] bin = binary.toCharArray();
//         int l = 0;
//         while(l < bin.length && bin[l] == '1') l++;
//         int z = 0;
//         for(int i = l; i < bin.length; i++) {
//             if(bin[i] == '0') z++;
//         }
//         Arrays.fill(bin, l, bin.length, '1');
//         if(z > 0) {
//             bin[l + z - 1] = '0';
//         }
//         return new String(bin);
//     }
// }