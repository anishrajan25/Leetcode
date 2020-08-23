class Solution {
    public String addBinary(String a, String b) {
        int i=a.length()-1,j=b.length()-1;
        StringBuilder ans=new StringBuilder();
        boolean carry=false;
        while(i>=0 && j>=0)
        {
            if(a.charAt(i)=='1' && b.charAt(j)=='1')
            {
                ans=carry?ans.append('1'):ans.append('0');
                carry=true;
            }
            else if(a.charAt(i)=='0' && b.charAt(j)=='0')
            {
                ans=carry?ans.append('1'):ans.append('0');
                carry=false;
            }
            else
            {
                ans=carry?ans.append('0'):ans.append('1');
            }
            i--;j--;
        }
        while(j>=0)
        {
            if(b.charAt(j)=='0')
            {
                ans=carry?ans.append('1'):ans.append('0');
                carry=false;
            }
            else
            {
                ans=carry?ans.append('0'):ans.append('1');
            }
            j--;
        }
        while(i>=0)
        {
            if(a.charAt(i)=='0')
            {
                ans=carry?ans.append('1'):ans.append('0');
                carry=false;
            }
            else
            {
                ans=carry?ans.append('0'):ans.append('1');
            }
            i--;
        }
        if(carry) ans.append('1');
        return ans.reverse().toString();
    }
}