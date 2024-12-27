class Solution {
    public int maxVowels(String s, int k) {
        int maxVowels = 0, currentVowels = 0;

        // Initialize the first window
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                currentVowels++;
            }
        }
        maxVowels = currentVowels;

        // Slide the window across the string
        for (int i = k; i < s.length(); i++) {
            // Remove the character going out of the window
            if (isVowel(s.charAt(i - k))) {
                currentVowels--;
            }
            // Add the character entering the window
            if (isVowel(s.charAt(i))) {
                currentVowels++;
            }
            // Update the maximum vowels found
            maxVowels = Math.max(maxVowels, currentVowels);
        }

        return maxVowels;
    }

    // Helper method to check if a character is a vowel
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

   
}
