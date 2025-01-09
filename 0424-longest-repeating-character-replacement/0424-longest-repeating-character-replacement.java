class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxWindow = 0;

        for(int right = 0;right< s.length() ;right++){
            //update freq of curr character
            freq[s.charAt(right) - 'A']++;
          //update maxfreq
           maxFreq = Math.max(maxFreq,freq[s.charAt(right) - 'A']);

           int windowLength = right - left +1 ;  

           if( windowLength - maxFreq > k){
            freq[s.charAt(left) - 'A']--;
            left++ ;
           } 
           windowLength = right - left + 1;
           maxWindow = Math.max(maxWindow,windowLength);    
       }

       return maxWindow;
    }
}