// https://leetcode.com/problems/maximum-score-after-splitting-a-string/


int maxScore(char * s){
    int len = strlen(s);
    int *sum1 = (int*)calloc(len, sizeof(int));
    
    for(int i = len - 1; i > 0; sum1[--i] = s[i] - '0' + sum1[i]);
    
    int sum0 = 0, res = 0;
    for(int i = 0; i < len - 1; i++) {
        sum0 += s[i] == '0' ? 1 : 0;
        res = fmax(res, sum0 + sum1[i]); 
    }
    free(sum1);
    return res;
}