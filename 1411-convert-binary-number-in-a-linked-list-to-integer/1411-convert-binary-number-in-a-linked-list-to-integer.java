/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        StringBuilder binaryStr = new StringBuilder();
        
        // Build the binary string from the linked list
        while (head != null) {
            binaryStr.append(head.val);
            head = head.next;
        }
        
        // Convert binary string to decimal integer
        return Integer.parseInt(binaryStr.toString(), 2);
    }
}