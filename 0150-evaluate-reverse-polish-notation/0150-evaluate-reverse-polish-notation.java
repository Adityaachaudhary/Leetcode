class Solution {
    public int evalRPN(String[] tokens) {
       Stack<Integer> st = new Stack<>();
       for (String token : tokens) {
            if (Character.isDigit(token.charAt(token.length() - 1))) {
                // If the token is a number, push it onto the stack
                st.push(Integer.parseInt(token));
            } 
            else {
            // Pop the top two elements for the operation
                int b = st.pop();
                int a = st.pop();

            // Perform the operation based on the operator
            if(token.equals("+")){
                st.push(a+b);
            }
             else if(token.equals("-")){
                st.push(a-b);
            }
            else if(token.equals("*")){
                st.push(a*b);
            }
            else if(token.equals("/")){
                st.push(a/b);
            }
        }
       }
       // The final result is at the top of the stack
        return st.pop(); 
    }
}