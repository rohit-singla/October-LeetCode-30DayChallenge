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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        ListNode last = head, temp = head;;
        int len = 1;
        while(last.next != null){
            len++;
            last = last.next;
        }
        k = k % len;
        if(k == 0) return head;
        for (int i = 1; i < len - k; i++) 
            temp = temp.next;
        ListNode ans = temp.next;
        temp.next = null;
        last.next = head;
        return ans;
    }
}