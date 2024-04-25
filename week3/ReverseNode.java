class Solution {
    public int getLength(ListNode head){
        int length = 0;
        while(head!=null){
            length++;
            head=head.next;
        }
        return length;
    }
    public ListNode reverse(ListNode head){
        if(head==null||head.next==null)
            return head;
        ListNode curr=head,prev=null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k, int N){
        if(head==null||head.next==null)
            return head;
        if(N<k)
            return head;
        ListNode begin = head;
        ListNode end = begin;
        int count = k;
        while(count-- > 1){
            end = end.next;
        }
        ListNode nextBatchHead = end.next;
        end.next=null;
        ListNode reverseHead = reverse(head);
        head.next = reverseKGroup(nextBatchHead,k,N-k);
        return reverseHead;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int N = getLength(head);
        return reverseKGroup(head,k,N);
    }
}