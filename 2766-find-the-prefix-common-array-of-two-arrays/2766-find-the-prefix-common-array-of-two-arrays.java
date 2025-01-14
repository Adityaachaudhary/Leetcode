class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;  
        int[] C = new int[n];  
        boolean[] seenA = new boolean[n + 1]; // To track elements seen in A  
        boolean[] seenB = new boolean[n + 1]; // To track elements seen in B  

        for (int i = 0; i < n; i++) {  
            // Mark the elements seen at index i  
            seenA[A[i]] = true;  
            seenB[B[i]] = true;  

            // Count common elements at index i  
            int commonCount = 0;  
            for (int j = 1; j <= n; j++) {  
                if (seenA[j] && seenB[j]) {  
                    commonCount++;  
                }  
            }  

            C[i] = commonCount; // Store the count in C  
        }  

        return C;  
    }  
}