class Solution {
    public String minWindow(String s, String t) {
        // Step 1: Check if the input is valid.
        // If s or t is null, empty, or if s is shorter than t, return an empty string.
        if (s == null || t == null || s.length() == 0 || t.length() == 0 
        || s.length() < t.length()) {
            return "";
        }

        // Step 2: Create a frequency map (array) to count occurrences 
        //of each character in t.
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        // Step 3: Initialize variables to track the number of
        // required characters, window boundaries, and the minimum window found.
        
        int count = t.length(); // Number of characters we need to match in s
        int start = 0; // Start index of the current window in s
        int minLen = Integer.MAX_VALUE; // Minimum length of the valid window found
        int startIndex = 0; // Start index of the minimum window found

        // Step 4: Iterate through s to find the minimum window
        // that contains all characters of t.
        for (int end = 0; end < s.length(); end++) {
            // If the current character in s is in t (map value > 0),
            // decrease the count of characters we need to match.
            if (map[s.charAt(end)]-- > 0) {
                count--;
            }

            // Step 5: When we have a valid window (count == 0),
            // try to shrink it to find the smallest window.
            while (count == 0) {
                // Update the minimum window length and its
                // start index if the current window is smaller.
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    startIndex = start;
                }

                // Slide the window to the right by increasing the start pointer.
                // Also, update the map and count if necessary.
                if (++map[s.charAt(start++)] > 0) {
                    count++;
                }
            }
        }

        // Step 6: If a valid window was found, return it as a
        // substring of s. Otherwise, return an empty string.
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
