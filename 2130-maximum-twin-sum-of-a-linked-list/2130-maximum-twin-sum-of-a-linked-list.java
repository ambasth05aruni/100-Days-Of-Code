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
    int ans=0;
    public int pairSum(ListNode head) {
      recur (  head , head);
      return ans;
    }    
    public ListNode recur( ListNode node , ListNode head ){        
        if( node == null ){
            return head;
        }
        ListNode t =  recur( node.next , head) ;
        ans = Math.max(ans ,  node.val + t.val );        
        return t.next;    
    }
}