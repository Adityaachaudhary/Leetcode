class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // If the list is empty, has only one node, or no need to reverse,
        // return the original head
        if (head == null || head.next == null || left == right) return head;

        // Create a dummy node with value 0 and point it to the 
        //head of the list
        ListNode res = new ListNode(0, head);
        // Initialize `prev` to point to the dummy node
        ListNode prev = res;

        // Move `prev` to the node just before the `left` position
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // `curr` points to the node at the `left` position
        ListNode curr = prev.next;

        // Perform the reversal process for the nodes between `left`
        // and `right`
        for (int i = 0; i < right - left; i++) {
            // `temp` points to the node immediately after 
            //`curr` (the node to be moved to the front)
            ListNode temp = curr.next;
            // Skip the `temp` node in the sublist by pointing 
            //`curr.next` to the node after `temp`
            curr.next = temp.next;
            // Insert `temp` at the front of the reversed sublist
            temp.next = prev.next;
            // Update `prev.next` to point to the newly inserted `temp` node
            prev.next = temp;
        }

        // Return the head of the modified list (skip the dummy node)
        return res.next;
    }
}
