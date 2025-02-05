class Solution {
    public int longestPalindrome(String s) {
    
        int count = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            if(freqMap.get(c) % 2 == 1){
                count++;
            }
            else {
                count--;
            }
        }
        if(count > 1 ){
            return s.length() - count +1;
        }
        return s.length();
    }

}