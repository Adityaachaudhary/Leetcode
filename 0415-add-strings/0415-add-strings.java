class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1;
            if (i >= 0) {
                digit1 = num1.charAt(i) - '0'; // Extract the digit from num1
            } else {
                digit1 = 0; // If index is out of bounds, treat it as 0
            }

            int digit2;
            if (j >= 0) {
                digit2 = num2.charAt(j) - '0'; // Extract the digit from num2
            } else {
                digit2 = 0; // If index is out of bounds, treat it as 0
            }

           

            int total = digit1 + digit2 + carry;
            carry = total / 10;

            result.append(total % 10);

            i--;
            j--;
        }

        return result.reverse().toString();
    }
}