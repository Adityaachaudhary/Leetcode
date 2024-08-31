class Solution {
    public int characterReplacement(String s, int k) {
         int maxLen = 0;       // To keep track of the maximum length of substring
    int maxCount = 0;     // To keep track of the count of the most frequent character in the current window
    int[] count = new int[26]; // Array to count characters

    int left = 0;         // Left end of the window

    for (int right = 0; right < s.length(); right++) {
        // Increase the count of the current character
        count[s.charAt(right) - 'A']++;

        // Update the count of the most frequent character in the current window
        maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

        // If the number of characters that need to be replaced exceeds k, move the left pointer
        if (right - left + 1 - maxCount > k) {
            count[s.charAt(left) - 'A']--;
            left++;
        }

        // Update the maximum length of substring
        maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
    }
}