import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        // A valid IP has between 4 and 12 digits.
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        
        // Start backtracking from index 0 with an empty list of segments
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int startIndex, List<String> segments, List<String> result) {
        // Base Case 1: If we have successfully formed exactly 4 segments
        if (segments.size() == 4) {
            if (startIndex == s.length()) {
                result.add(String.join(".", segments));
            }
            return; // Backtrack because we can't have more than 4 segments
        }

        // Base Case 2: If we reached the end of the string but don't have 4 segments yet
        if (startIndex == s.length()) {
            return;
        }

        // Try taking 1, 2, or 3 digits for the next segment
        for (int len = 1; len <= 3; len++) {
            if (startIndex + len > s.length()) {
                break;
            }

            // Extract the substring for the current segment
            String segment = s.substring(startIndex, startIndex + len);

            // Check if this segment is valid:
            // 1. No leading zeros (e.g., "0" is fine, but "01" or "00" is not).
            // 2. The numerical value must be between 0 and 255.
            if ((segment.startsWith("0") && segment.length() > 1) || Integer.parseInt(segment) > 255) {
                continue; // Skip invalid segments
            }

            // Choose: Add the valid segment to our list
            segments.add(segment);

            // Explore: Move to the next index in the string
            backtrack(s, startIndex + len, segments, result);

            // Unchoose: Remove the last added segment to try other possibilities (backtracking)
            segments.remove(segments.size() - 1);
        }
    }
}