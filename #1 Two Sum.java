import java.util.Arrays; 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] aux = nums.clone(); 
        Arrays.sort(nums);
        int[] ans = new int[2];
        int i=0,j=nums.length-1,m=0,n=0;
        while(nums[i]+nums[j]!=target )
        {
           if(nums[i]+nums[j]<target)
               i++;
            else
                j--;
        }
        
       for(m =0 ; m <aux.length;m++)
       {
           if(aux[m] == nums[i])
           {
               ans[0]=m;
               break;
           }
       }
        
       for(n =0 ; n <aux.length;n++)
       {
           if(aux[n] == nums[j]&& n!=m)
           {
               ans[1]=n;
               break;
           }
       }  
        
       return ans; 
    }
}