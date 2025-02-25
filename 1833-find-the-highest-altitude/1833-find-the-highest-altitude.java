class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] altitude = new int[n+1];
        int maxAltitude = 0;
        altitude[0] = 0;

        for(int  i = 0;i<n;i++){
            altitude[i+1] = altitude[i] + gain[i];
            maxAltitude = Math.max(maxAltitude,altitude[i+1]);
        }
        return maxAltitude;   
    }
}