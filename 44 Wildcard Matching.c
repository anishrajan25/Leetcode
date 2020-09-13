// https://leetcode.com/problems/wildcard-matching/

bool isMatch(char * s, char * p){
    int slen = strlen(s), plen = strlen(p), str = -1, patt = -1, i = 0, j = 0;
    
    while(i<slen) {
        if(j<plen && (p[j] == s[i] || p[j] == '?')) i++,j++;
        else if(j<plen && p[j] == '*') {
            str = i;
            patt = j++;
        }
        else if(patt != -1) {
            i = ++str;
            j = 1 + patt;
        }
        else return false;
    }
    while(j<plen && p[j] == '*') ++j;
    return j == plen; 
}