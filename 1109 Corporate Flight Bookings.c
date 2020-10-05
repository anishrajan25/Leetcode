// https://leetcode.com/problems/corporate-flight-bookings/

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* corpFlightBookings(int** bookings, int bookingsSize, int* bookingsColSize, int n, int* returnSize){
    int *res = (int*)calloc(n+1, sizeof(int));
    
    for(int x = 0; x < bookingsSize; ++x) {
        res[bookings[x][0] - 1] += bookings[x][2];
        res[bookings[x][1]] -= bookings[x][2];
    }
    
    for(int i = 1; i <= n; res[i] += res[i-1], i++);
    
    *returnSize = n;
    return res;
}