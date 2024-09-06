class Solution {
    public void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k%n;

        reverse(arr,n-k,n-1);
        reverse(arr,0,n-k-1);
        reverse(arr,0,n-1);
        
    }
        
    public static void reverse(int[] arr,int i,int j){
        int n = arr.length;
        while( i <= j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }    
    public static void swap(int[] arr,int i,int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
}