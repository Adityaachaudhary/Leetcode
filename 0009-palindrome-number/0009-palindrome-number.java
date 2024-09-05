class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers and numbers that end with 0 (except 0 itself) cannot be palindromes
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int reversed = 0;
        int original = x;

        // Reverse the number
        while (x > 0) {
            int digit = x % 10;   // Extract the last digit
            reversed = reversed * 10 + digit; 
            // Add the digit to the reversed number
            x /= 10;  // Remove the last digit from the original number
        }

        // Check if the reversed number is the same as the original
        return original == reversed;
    }
}
