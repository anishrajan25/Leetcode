// https://leetcode.com/problems/reduce-array-size-to-the-half/

class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> numCounts = new HashMap();
        for(int num : arr) numCounts.put(num, numCounts.getOrDefault(num,0)+1);
        
        Queue<Integer> frequencies = new PriorityQueue<>((a, b) -> b - a);
        for(int num : numCounts.values()) frequencies.add(num);
        
        int current = 0;
        int size = 0;
        int halfLength = arr.length / 2;
        
        while(current < halfLength){
            current += frequencies.poll();
            size++;
        }
        
        return size;
    }
}