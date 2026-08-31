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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1, prev = -1, min = Integer.MAX_VALUE, i = 1;
        
        for (ListNode curr = head; curr.next != null && curr.next.next != null; curr = curr.next, i++) {
            int a = curr.val, b = curr.next.val, c = curr.next.next.val;
            
            //Check if 'b' is a local peak or valley
            if ((b > a && b > c) || (b < a && b < c)) {
                if (first == -1) first = i;
                else min = Math.min(min, i - prev);
                prev = i;
            }
        }
        
        return first == prev ? new int[]{-1, -1} : new int[]{min, prev - first};
    }
}