// https://leetcode.com/problems/online-election/

class TopVotedCandidate {
    int[] t;
    public TopVotedCandidate(int[] persons, int[] times) {
        t = new int[times[times.length - 1] + 1];
        int k = times[0];
        HashMap<Integer, Person> hm = new HashMap();
        Person p = null;
        for(int i = 0; i < persons.length; ++i) {
            if(!hm.containsKey(persons[i])) hm.put(persons[i], hm.getOrDefault(persons[i], new Person(times[i], 0, persons[i])));
            Person tmp = hm.get(persons[i]);
            tmp.c++;
            // System.out.println(i + "\t" + hm.get(persons[i]).id + " " + hm.get(persons[i]).c);
            if(p == null) p = tmp;
            else if(p.c <= tmp.c) p = tmp;
            while(k < times[i]) {
                t[k] = t[k-1];
                k++;
            }
            t[k++] = p.id;
            // System.out.println(hm.keySet());
        }
    }
    
    public int q(int time) {
        if(time > t.length - 1) return t[t.length - 1]; 
        return t[time];
    }
}

class Person {
    int t, c, id;
    
    Person(int t, int c, int id) {
        this.t = t;
        this.c = c;
        this.id = id;
    }
}
/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */