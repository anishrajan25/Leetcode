// https://leetcode.com/problems/largest-time-for-given-digits/

class Solution {
    private int max_time = -1;

    public String largestTimeFromDigits(int[] A) {
        this.max_time = -1;
        permutate(A, 0);
        if (this.max_time == -1)
            return "";
        else
            return String.format("%02d:%02d", max_time / 60, max_time % 60);
    }

    protected void permutate(int[] array, int start) {
        if (start == array.length) {
            this.build_time(array);
            return;
        }
        for (int i = start; i < array.length; ++i) {
            this.swap(array, i, start);
            this.permutate(array, start + 1);
            this.swap(array, i, start);
        }
    }

    protected void build_time(int[] perm) {
        int hour = perm[0] * 10 + perm[1];
        int minute = perm[2] * 10 + perm[3];
        if (hour < 24 && minute < 60)
            this.max_time = Math.max(this.max_time, hour * 60 + minute);
    }

    protected void swap(int[] array, int i, int j) {
        if (i != j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}

/* 
class Solution {
    public String largestTimeFromDigits(int[] A) {
        // sanity check
        if (A == null || A.length == 0) {
            return new String();
        }
        
        String result = startWithTwo(A);
        
        if (result.length() == 0) {
            return startWithoutTwo(A);
        }
        
        return result;
    }
    
    private String startWithoutTwo(int[] A) {
        int[] result = new int[4];
        int[] count = new int[10];
        for (int num : A) {
            count[num]++;
        } 
        
        if (count[0] == 0 && count[1] == 0) {
            return new String();
        }
        
        if (count[1] > 0) {
            result[0] = 1;
            count[1]--;
        } else {
            result[0] = 0;
            count[0]--;
        }
        
        for (int i = 5; i >= 0; i--) {
            if (count[i] > 0) {
                result[2] = i;
                count[i]--;
                break;
            }
            
            if (i == 0) {
                return new String();
            }
        }
        
        for (int i = 9; i >= 0; i--) {
            if (count[i] > 0) {
                result[1] = i;
                count[i]--;
                break;
            }
            
            if (i == 0) {
                return new String();
            }
        }
        
        if (result[1] < result[2]) {
            int temp = result[1];
            result[1] = result[2];
            result[2] = temp;
        }
        for (int i = 9; i >= 0; i--) {
            if (count[i] > 0) {
                result[3] = i;
                count[i]--;
                break;
            }
            
            if (i == 0) {
                return new String();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(result[0]);
        sb.append(result[1]);
        sb.append(":");
        sb.append(result[2]);
        sb.append(result[3]);
        
        return sb.toString();
    }
    
    private String startWithTwo(int[] A) {
        int[] result = new int[4];
        int[] count = new int[10];
        for (int num : A) {
            count[num]++;
        }
        
        if (count[2] == 0) {
            return new String();
        }
        
        result[0] = 2;
        count[2]--;
        
        for (int i = 3; i >= 0; i--) {
            if (count[i] > 0) {
                result[1] = i;
                count[i]--;
                break;
            }
            
            if (i == 0) {
                return new String();
            }
        }
        
        for (int i = 5; i >= 0; i--) {
            if (count[i] > 0) {
                result[2] = i;
                count[i]--;
                break;
            }
            
            if (i == 0) {
                return new String();
            }
        }
        
        for (int i = 9; i >= 0; i--) {
            if (count[i] > 0) {
                result[3] = i;
                count[i]--;
                break;
            }
            
            if (i == 0) {
                return new String();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(result[0]);
        sb.append(result[1]);
        sb.append(":");
        sb.append(result[2]);
        sb.append(result[3]);
        
        return sb.toString();
    }
    
}
*/