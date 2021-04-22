package leetcode;

/**
 * @ClassName: RemoveElements
 * @Description 203. 移除链表元素 https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @Author Ryan
 * @Date 2021.4.22 20:43
 * @Version 1.0.0-Beta
 **/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel  = new ListNode(0,head);

        ListNode cur = head;
        ListNode prev = sentinel ;
        while(cur!=null){
            if(cur.val == val){
                prev.next = cur.next;
            }
            else{
                prev = cur;
            }
            cur = cur.next;

        }
        return sentinel .next;

    }

    public static void main(String[] args) {


    }
}
