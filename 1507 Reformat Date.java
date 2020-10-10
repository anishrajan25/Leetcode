// https://leetcode.com/problems/reformat-date/


class Solution {
    public String reformatDate(String date) {
        String d[] = date.split(" ");
        
        StringBuilder ans = new StringBuilder(d[2]);
        ans.append("-");
        
        switch(d[1]) {
            case "Jan":
                ans.append("01-");
                break;
            case "Feb":
                ans.append("02-");
                break;
            case "Mar":
                ans.append("03-");
                break;
            case "Apr":
                ans.append("04-");
                break;
            case "May":
                ans.append("05-");
                break;
            case "Jun":
                ans.append("06-");
                break;
            case "Jul":
                ans.append("07-");
                break;
            case "Aug":
                ans.append("08-");
                break;
            case "Sep":
                ans.append("09-");
                break;
            case "Oct":
                ans.append("10-");
                break;
            case "Nov":
                ans.append("11-");
                break;
            case "Dec":
                ans.append("12-");
                break;
        }
        
        int i = 0;
        while(d[0].charAt(i) >= '0' && d[0].charAt(i) <= '9') ans.append(String.valueOf(d[0].charAt(i++)));
        
        if(ans.length() != 10) ans.insert(8, "0");
        return ans.toString();
    }
}