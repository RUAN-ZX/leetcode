package leetcode.TwoPointer;

/**
 * @ClassName: MergeTwoLists  21. 合并两个有序链表
 * @Description https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @Author Ryan
 * @Date 2021.4.30 19:44
 * @Version 1.0.0-Beta
 **/
public class MergeTwoLists {

     static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


     /*
        思路很简单 遍历 谁小就要谁的

      */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode p = pre;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                p.next = l1;
                l1 = l1.next;
            }
            else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        p.next = (l1==null) ? l2:l1;

        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(2, new ListNode(4,null)));
        ListNode l2 = new ListNode(2,new ListNode(30, new ListNode(40,null)));
        ListNode temp = mergeTwoLists(l1,l2);
        while(temp.next!=null){
            System.out.println(temp.val+"->");
            temp = temp.next;
        }
    }
}
