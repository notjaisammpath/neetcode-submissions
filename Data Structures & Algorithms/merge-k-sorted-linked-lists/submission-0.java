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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode output = new ListNode(0);
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val); //k elem pq
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null)
                pq.offer(lists[i]);
        }
        ListNode cur = output;
        while(!pq.isEmpty()) {
            ListNode bruh = pq.poll();
            ListNode bruh2 = bruh.next;
            bruh.next = null;
            cur.next = bruh;
            if(bruh2 != null) {
                pq.offer(bruh2);
            }
            cur = cur.next;
        }
        return output.next;
    }
}
