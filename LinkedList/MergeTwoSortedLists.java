class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1=list1;
        ListNode temp2=list2;
        ListNode h=new ListNode(100);
        ListNode t=h;
        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
            
              t.next=temp1;
              t=temp1;
              temp1=temp1.next; 
            }else{
              t.next=temp2;
              t=temp2;
              temp2=temp2.next;
            }
        }

        if(temp1==null){
            t.next=temp2;
        }else{
            t.next=temp1;
        }
    return h.next;
    }
}