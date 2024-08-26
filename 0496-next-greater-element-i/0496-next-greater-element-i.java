public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map to store the next greater element for each number in nums2
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        // Stack to keep track of elements in nums2
        Stack<Integer> stack = new Stack<>();
        
        // Iterate through nums2
        for (int num : nums2) {
            // Pop elements from the stack until you find a greater element
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterMap.put(stack.pop(), num);
            }
            // Push the current element onto the stack
            stack.push(num);
        }
        
        // For remaining elements in the stack, no greater element exists,
        // so map them to -1
        while (!stack.isEmpty()) {
            nextGreaterMap.put(stack.pop(), -1);
        }
        
        // Build the result array for nums1 based on the map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }
        
        return result;
    }
}