class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int left = 0;
        int Count = 0;
        String bestSubstring = "";
        
        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                Count++;
            }
            while (Count == k) {
                String currentWindow = s.substring(left, right + 1);
                
                //Update bestSubstring if we found a better candidate
                if (bestSubstring.isEmpty() || currentWindow.length() < bestSubstring.length()) {
                    bestSubstring = currentWindow;
                } else if (currentWindow.length() == bestSubstring.length()) {
                    if (currentWindow.compareTo(bestSubstring) < 0) {
                        bestSubstring = currentWindow;
                    }
                }
                
                //Slide the left pointer to shrink the window
                if (s.charAt(left) == '1') {
                    Count--;
                }
                left++;
            }
        }
        
        return bestSubstring;
    }
}