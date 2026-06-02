class Solution {
    private int[] memo = new int[46];

    public int climbStairs(int n) {
       if(n==0) {
        return 1;
       } 

       if(n<0) {
        return 0;
       }

       if(memo[n] != 0) {
        return memo[n];
       }

       return memo[n] = climbStairs(n-1) + climbStairs(n-2);
    }
}




/*
 n=1 1
 n=2 2
 n=3 3
 n=4
 1+1+1+1
 1+1+2
 2+2
 1+2+1
 2+1+1





*/
