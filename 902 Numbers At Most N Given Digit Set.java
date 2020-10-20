// https://leetcode.com/problems/numbers-at-most-n-given-digit-set/



// If we make a number of length x, where x is always < length of n
// then we can make digits.length^k numbers. we store the count of these numbers in variable "smaller"

// Now If we make a number of len k where k is equal to length of n, then if the first digit of the number is less than
// the digit at the same position in n, then we can make digits.length^(k - 1) numbers
// E.g. for 2345 if we make a number like xyyy and we take some x from digits (x<2)
// then we can place any digit from digits in place of the y's
// hence digits.length^(k - 1) numbers are possible
// But if we select x = 2, then we'll have to check for 345, that how many numbers can be made 
// with first digit == 3 and <3. so same steps would have to be repeated
// the result of these computations will be stored in the varialbe res

// SO now we start calculating for numbers of length 1 and upto length of n
// and we calculate how many numbers can be made if we choose x to be equal to the corresponding value in n
// And simultaneously we'll calculate value of 'smaller'


class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        char[] N = String.valueOf(n).toCharArray();
        int len = N.length;
        int res = 1, pres = 1, smaller = -1;
        
        for(int i = 1, m = 1; i <= len; i++, m *= digits.length) {
            pres = res;
            res = 0;
            int x = N[len-i] - '0';
            for(String d: digits) {
                if(Integer.valueOf(d) < x) res += m;
                else if(Integer.valueOf(d) == x) res += pres;
            }
            smaller += m;
        }
        
        return res + smaller;
    }
}



// this is the same approach as Leetcode's first solution

// Approach 1: Dynamic Programming + Counting
// Intuition

// First, call a positive integer X valid if X <= N and X only consists of digits from D. Our goal is to find the number of valid integers.

// Say N has K digits. If we write a valid number with k digits (k < K), then there are (D\text{.length})^k(D.length) 
// k
//   possible numbers we could write, since all of them will definitely be less than N.

// Now, say we are to write a valid K digit number from left to right. For example, N = 2345, K = 4, and D = '1', '2', ..., '9'. Let's consider what happens when we write the first digit.

// If the first digit we write is less than the first digit of N, then we could write any numbers after, for a total of (D\text{.length})^{K-1}(D.length) 
// K−1
//   valid numbers from this one-digit prefix. In our example, if we start with 1, we could write any of the numbers 1111 to 1999 from this prefix.

// If the first digit we write is the same, then we require that the next digit we write is equal to or lower than the next digit in N. In our example (with N = 2345), if we start with 2, the next digit we write must be 3 or less.

// We can't write a larger digit, because if we started with eg. 3, then even a number of 3000 is definitely larger than N.

// Algorithm

// Let dp[i] be the number of ways to write a valid number if N became N[i], N[i+1], .... For example, if N = 2345, then dp[0] would be the number of valid numbers at most 2345, dp[1] would be the ones at most 345, dp[2] would be the ones at most 45, and dp[3] would be the ones at most 5.

// Then, by our reasoning above, dp[i] = (number of d in D with d < S[i]) * ((D.length) ** (K-i-1)), plus dp[i+1] if S[i] is in D.