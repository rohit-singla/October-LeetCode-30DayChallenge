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
    
	public static ListNode middle(ListNode head) {
        if (head == null) return head;
        
        ListNode slow = head, fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public static ListNode mergeTwoList(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        
        ListNode newHead = null, newTail = null;
        
        if (head1.val < head2.val) {
            newHead = head1;
            newTail = head1;
            head1 = head1.next;
        } else {
            newHead = head2;
            newTail = head2;
            head2 = head2.next;
        }
        
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                newTail.next = head1;
                newTail = newTail.next;
                head1 = head1.next;
            } else {
                newTail.next = head2;
                newTail = newTail.next;
                head2 = head2.next;
            }
        }
      
        if (head1 != null) newTail.next = head1;
        if (head2 != null) newTail.next = head2;
        
        return newHead;
    }
    
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode mid = middle(head);
        
        ListNode half1 = head;
        ListNode half2 = mid.next;
        mid.next = null;
        
        half1 = sortList(half1);
        half2 = sortList(half2);
      
        ListNode finalhead = mergeTwoList(half1, half2);
        
        return finalhead;
    }
}