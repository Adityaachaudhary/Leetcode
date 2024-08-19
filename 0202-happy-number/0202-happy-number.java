class Solution {
    public boolean isHappy(int n) {
        int slow = n;          // This represents the "head" pointer.
        int fast = next(n);    // This represents the "head.next" pointer.

        while (fast != 1 && slow != fast) {
            slow = next(slow);         // Move slow one step (i.e., one transformation).
            fast = next(next(fast));   // Move fast two steps (i.e., two transformations).
        }

        return fast == 1; // If fast pointer reaches 1, the number is happy.
    }

    // Helper function renamed to `next` to calculate the next number in the sequence.
    private int next(int n) {
        int total = 0;
        while (n > 0) {
            int digit = n % 10;
            total += digit * digit;
            n /= 10;
        }
        return total;
    }
}
