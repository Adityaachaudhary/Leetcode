class Solution {
    public String removeStars(String s) {
       char[] arr = new char[s.length()];
       int i = 0;
       for(int j = 0;j<s.length();j++){
        char c = s.charAt(j);
        if(c == '*'){
            i--;
        }
        else {
            arr[i] = c;
            i++;
        }
       }
       StringBuilder sb = new StringBuilder();
       for(int j = 0;j<i;j++){
        sb.append(arr[j]);
       } 

       return sb.toString();
       
    }
}