class Solution {
    public int maximumLengthSubstring(String s) {
        int maxLength = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int[] count = new int[26];
            
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                count[ch - 'a']++;

                if (count[ch - 'a'] > 2) {
                    break;
                }
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
    }
}