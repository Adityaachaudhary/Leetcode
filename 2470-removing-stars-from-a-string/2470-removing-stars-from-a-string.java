class Solution {
    public String removeStars(String s) {
        StringBuilder str = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
// Remove the last character from the StringBuilder if '*' is encountered
                str.deleteCharAt(str.length() - 1);
            } else {
    // Append the current character from the input string 's'
                str.append(s.charAt(i));
            }
        }
        
        return str.toString();
    }
}
