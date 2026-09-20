class Solution {
    public int reverseDegree(String s) {
       int sum = 0;
       for(int i = 0;i<s.length();i++){
        char ch = s.charAt(i);

        int reverseAlphabet = 26 - (ch - 'a');

        int stringidx = i+1;
        sum += reverseAlphabet * stringidx;
       } 
       return sum;
    }
}