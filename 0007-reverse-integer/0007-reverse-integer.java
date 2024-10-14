class Solution {
    public int reverse(int x) {
       int reversed = 0;
       while(x != 0){ 
        int rem = x%10;
        x /= 10;

        if (reversed>Integer.MAX_VALUE / 10 || reversed<Integer.MIN_VALUE / 10)
        { 
            return 0; // Return 0 if overflow occurs
        }
        reversed = reversed*10 + rem;
       }
       return reversed;
    }
}