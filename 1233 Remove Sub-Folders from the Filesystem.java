// https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res = new ArrayList();
        for(int i = 0; i < folder.length; ++i) {
            res.add(folder[i]);
            String tmp = folder[i] + "/";
            while(i < folder.length - 1 && folder[i + 1].indexOf(tmp) != -1) i++;
        }
        
        return res;
    }
}