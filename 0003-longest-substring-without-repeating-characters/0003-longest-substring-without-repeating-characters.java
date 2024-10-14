class Solution {
    public int lengthOfLongestSubstring(String s) {
        int arr[] = new int[127];
        int si =0;
        int ei=0;
        int len =0;
        while(ei<s.length()){
            arr[s.charAt(ei)]++;
            while(arr[s.charAt(ei)]>1 && si<ei){
                arr[s.charAt(si)]--;
                si++;
            }
            len = Math.max(len,ei-si+1);
            ei++;
        }
        return len;
    }
    
}