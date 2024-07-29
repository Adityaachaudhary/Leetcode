class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left =0;int right =0;
        int res = 0;
        Map<Character,Integer> map = new HashMap();
        char[] arr = s.toCharArray();
        
         for( ; right < arr.length ; right++){
            int idx = map.getOrDefault(arr[right], -1);
            if(idx != -1 && idx >= left){
                res = Math.max(res,right - 1 - left + 1);
                left = idx + 1;
            }
            map.put(arr[right], right);
         }
         return Math.max(res,right - 1 - left + 1);
    }
        
}