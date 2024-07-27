class Solution {
    public int removeDuplicates(int[] n) {
        int i=0;
        for(int j=1;j<n.length;j++){
           if(n[j] != n[i]){
               i++;
              n[i]=n[j];
//The current element n[j] is then copied to the position i in the array. 
//This updates the array to move the unique element to the front.
           }
            
        }
        return i+1;
    }
}