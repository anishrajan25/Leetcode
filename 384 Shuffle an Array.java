class Solution {
    int[] org,arr;
    Random r=new Random();
    public Solution(int[] nums) {
        arr=nums;
        org=nums.clone();
    }
    
    public int[] reset() {
        arr=org;
        org=org.clone();
        return arr;
    }
    
    public int[] shuffle() {
        for(int i=0;i<arr.length;i++)
        {
            int x=r.nextInt(arr.length-i),t=arr[i];
            arr[i]=arr[x+i];
            arr[x+i]=t;
        }
        return arr;
    }
}