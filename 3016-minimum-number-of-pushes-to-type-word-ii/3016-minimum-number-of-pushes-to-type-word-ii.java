import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        //Count how often each letter appears
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        Arrays.sort(freq);
        
        int totalPushes = 0;
        int distinctCount = 0; 
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) {
                break; //No more letters left to assign
            }
            
            //Calculate the cost for this letter
            int cost = (distinctCount / 8) + 1;
            totalPushes += freq[i] * cost;
            
            distinctCount++;
        }
        
        return totalPushes;
    }
}