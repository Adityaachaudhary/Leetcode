class Solution {
    public int maxScore(String s) {
        int totalzeros = 0;
        int ans = -1;
        int zeros = 0;
        int n = s.length();
        for( char c : s.toCharArray()){
            if(c == '0') totalzeros++;
        }
        for(int i = 1;i<n;i++){
            if(s.charAt(i-1) == '0'){
                zeros++;
                totalzeros--;
            }
            ans = Math.max(ans,zeros + (n- totalzeros -i));
        }
        return ans;
    }
}