class Solution {
    public int longestValidParentheses(String s) {
        LinkedList<Integer> st = new LinkedList<Integer>();
        st.push(-1);
        int l = s.length();
        int maxLen = 0;
        for(int i = 0; i < l; i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }else{
                    int len = i - st.peek();
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        return maxLen;   
    }
}