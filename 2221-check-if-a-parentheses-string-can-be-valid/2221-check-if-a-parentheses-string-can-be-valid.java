class Solution {
    public boolean canBeValid(String s, String locked) {
        // If the length of s is odd, it can never be valid  
        if (s.length() % 2 != 0) return false;  

        int openNeeded = 0;  
        int closeNeeded = 0;  

        // First pass: left to right  
        for (int i = 0; i < s.length(); i++) {  
            if (locked.charAt(i) == '1') {  
                // Count '(' and ')' based on locked  
                if (s.charAt(i) == '(') {  
                    openNeeded++;  
                } else {  
                    closeNeeded++;  
                }  
            } else {  
                // For '0' we can count both possibilities  
                openNeeded++; // Assume we can put an open parenthesis  
            }  

// If at any point close needed exceeds open needed, it can't be valid  
            if (closeNeeded > openNeeded) return false;  
        }  

        openNeeded = 0;  
        closeNeeded = 0;  

        // Second pass: right to left  
        for (int i = s.length() - 1; i >= 0; i--) {  
            if (locked.charAt(i) == '1') {  
                if (s.charAt(i) == ')') {  
                    closeNeeded++;  
                } else {  
                    openNeeded++;  
                }  
            } else {  
                closeNeeded++; // Assume we can put a close parenthesis  
            }  

    // If at any point open needed exceeds close needed, it can't be valid  
            if (openNeeded > closeNeeded) return false;  
        }  

        // If we pass both checks, then it is valid  
        return true;  
    }   
}