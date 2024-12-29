class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n < 2) return n; // If string length is 0 or 1, return the length.

        int left = 0; 
        int right = 0;
        int maxLength = 0; // To track the maximum length of substring
        HashMap<Character, Integer> map = new HashMap<>();

        while (right < n) {
            char ch = s.charAt(right); //Get the character at the right pointer

            //If the character is already in the map, move the left pointer
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);//Update left to avoid overlapping
            }

            // Update the character's latest index in the map
            map.put(ch, right);

            // Calculate the maximum length
            maxLength = Math.max(maxLength, right - left  + 1 );

            // Move the right pointer
            right++;
        }

        return maxLength; // Return the maximum length of substring
    }
}
