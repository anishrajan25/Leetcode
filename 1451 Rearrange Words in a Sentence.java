// https://leetcode.com/problems/rearrange-words-in-a-sentence/

class Solution {
    public String arrangeWords(String text) {
        String[] arr = text.split(" ");
        arr[0] =  "" + (char)(arr[0].charAt(0) + 32) + arr[0].substring(1);
        Arrays.sort(arr, (a, b) -> a.length() - b.length());
        StringBuilder res = new StringBuilder(arr[0]);
        res.setCharAt(0, (char)(res.charAt(0) - 32));
        for(int i = 1; i < arr.length; ++i) res.append(" ").append(arr[i]);
        return res.toString();
    }
}