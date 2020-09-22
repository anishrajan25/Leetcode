// https://leetcode.com/problems/construct-the-rectangle/

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* constructRectangle(int area, int* returnSize){
    int *rect = (int*)calloc(2, sizeof(int));
    *returnSize = 2;
    
    int k = sqrt(area);
    
    while(k > 0) {
        if(area % k == 0) {
            rect[1] = k;
            rect[0] = area/k;
            break;
        }
        k--;
    }
    
    return rect;
}