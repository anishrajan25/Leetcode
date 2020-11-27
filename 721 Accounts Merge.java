// https://leetcode.com/problems/accounts-merge/

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList();
        Map<String, List<Set<String>>> hm = new HashMap();
        int i = 0;
        for(List<String> tmp: accounts) {
            if(!hm.containsKey(tmp.get(0))) {
                List<Set<String>> l = new ArrayList();
                Set<String> hs = new HashSet();
                for(int j = 1; j < tmp.size(); ++j) hs.add(tmp.get(j));
                l.add(hs);
                hm.put(tmp.get(0), l);
                continue;
            }
            i = -1;
            List<Set<String>> lohs = hm.get(tmp.get(0));
            search: {
                for(int j = 1; j < tmp.size(); ++j) {
                    for(int k = 0; k < lohs.size(); ++k) {
                        if(lohs.get(k).contains(tmp.get(j))) {
                            i = k;
                            break search;
                        }
                    }
                }
            }
            if(i != -1) {
                Set<String> hs = hm.get(tmp.get(0)).get(i);
                for(int j = 1; j < tmp.size(); ++j) hs.add(tmp.get(j));
            }
            else {
                Set<String> hs = new HashSet();
                for(int j = 1; j < tmp.size(); ++j) hs.add(tmp.get(j));
                hm.get(tmp.get(0)).add(hs);
            }
        }
        
        for(String name: hm.keySet()) {
            List<Set<String>> info = hm.get(name);
            for(int j = 0; j < info.size() - 1; ++j) {
                boolean dec = false;
                for(int k = j + 1; k < info.size(); ++k) {
                    Set<String> first = new HashSet(info.get(j));
                    first.addAll(info.get(k));
                    if(first.size() != info.get(j).size() + info.get(k).size()) {
                        info.get(j).addAll(info.get(k));
                        info.remove(k);
                        dec = true;
                        k--;
                    }
                }
                if(dec) --j;
            }
            for(Set<String> mail: hm.get(name)) {
                List<String> acc = new ArrayList(mail);
                Collections.sort(acc);
                acc.add(0, name);
                res.add(acc);
            }
        }
        
        return res;
    }
}

// class Solution {
//     public List<List<String>> accountsMerge(List<List<String>> accounts) {
//         List<List<String>> res = new ArrayList();
//         Map<String, List<Set<String>>> hm = new HashMap();
//         int i = 0;
//         for(List<String> tmp: accounts) {
//             if(!hm.containsKey(tmp.get(0))) {
//                 List<Set<String>> l = new ArrayList();
//                 Set<String> hs = new HashSet();
//                 for(int j = 1; j < tmp.size(); ++j) hs.add(tmp.get(j));
//                 l.add(hs);
//                 hm.put(tmp.get(0), l);
//                 continue;
//             }
//             // i = -1;
//             // List<Set<String>> lohs = hm.get(tmp.get(0));
//             // search: {
//             //     for(int j = 1; j < tmp.size(); ++j) {
//             //         for(int k = 0; k < lohs.size(); ++k) {
//             //             if(lohs.get(k).contains(tmp.get(j))) {
//             //                 i = k;
//             //                 break search;
//             //             }
//             //         }
//             //     }
//             // }
//             // if(i != -1) {
//             //     Set<String> hs = hm.get(tmp.get(0)).get(i);
//             //     for(int j = 1; j < tmp.size(); ++j) hs.add(tmp.get(j));
//             // }
//             else {
//                 String name = tmp.get(0);
//                 Set<String> hs = new HashSet();
//                 for(int j = 1; j < tmp.size(); ++j) hs.add(tmp.get(j));
//                 boolean add = false;
//                 List<Set<String>> info = hm.get(name);
//                 for(int j = 0; j < info.size() - 1; ++j) {
//                     Set<String> first = new HashSet(info.get(j));
//                     first.addAll(hs);
//                     if(first.size() != info.get(j).size() + hs.size()) {
//                         info.get(j).addAll(hs);
//                         add = true;
//                         break;
//                     }
//                 }
//                 if(!add) hm.get(tmp.get(0)).add(hs);
//             }
//         }
        
//         for(String name: hm.keySet()) {
//             List<Set<String>> info = hm.get(name);
//             for(int j = 0; j < info.size() - 1; ++j) {
//                 boolean dec = false;
//                 for(int k = j + 1; k < info.size(); ++k) {
//                     Set<String> first = new HashSet(info.get(j));
//                     first.addAll(info.get(k));
//                     if(first.size() != info.get(j).size() + info.get(k).size()) {
//                         info.get(j).addAll(info.get(k));
//                         info.remove(k);
//                         dec = true;
//                         k--;
//                     }
//                 }
//                 if(dec) --j;
//             }
//             for(Set<String> mail: hm.get(name)) {
//                 List<String> acc = new ArrayList(mail);
//                 Collections.sort(acc);
//                 acc.add(0, name);
//                 res.add(acc);
//             }
//         }
        
//         return res;
//     }
// }