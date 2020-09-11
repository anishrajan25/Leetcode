class Solution {
    public int search(int[] A, int target) {
        if(A.length==0)return -1;
        int n=A.length, lo=0,hi=n-1;
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(A[mid]>A[hi]) lo=mid+1;
            else hi=mid;
        }
        if(target>=A[lo] && target<=A[n-1])
            hi=n-1;
        else
            lo=0;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(A[mid]==target)return mid;
            if(A[mid]<target)lo=mid+1;
            else hi=mid-1;
        }
        return -1;
    }
}