package leetcode.RecursionAndIteration;

/**
 * @ClassName: linkedListReverse
 * @Description 链表翻转问题 迭代法与递归法
 * @Author Ryan
 * @Date 2021.4.22 12:58
 * @Version 1.0.0-Beta
 **/
public class linkedListReverse {
    final static int LinkedListLength = 50;
    static class Node{
        int val;
        Node next;

        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    public static Node initLinkedList(){
        Node[] LinkedList = new Node[LinkedListLength];
        LinkedList[LinkedListLength-1] = new Node(LinkedListLength - 1, null);
        for (int i = LinkedListLength-2; i >= 0; i--) {
            LinkedList[i] = new Node(i, LinkedList[i + 1]);
            // 0->1->2->3 ... -> LinkedListLength-1
        }
        return LinkedList[0];
    }

    public static void showLinkedList(Node head){
        Node node = head;
        while(node!=null){
            System.out.println(node.val+"->");
            node = node.next;
        }
    }

    public static void showLinkedListByRecursion(Node head){
        if(head == null || head.next == null)
            return ;
        System.out.println(head.val+"->");
        showLinkedListByRecursion(head.next);
    }
    public static Node reverseByRecursion(Node head){
        if(head == null || head.next == null)
            return head;

//        System.out.println(head.val+"->");
        Node temp = reverseByRecursion(head.next);
        head.next.next = head;
        head.next = null;

        return temp;
    }
    public static Node reverseByIteration(Node head){
        Node curNode = head;
        Node prev = null;
        Node next = null;
        while(curNode!=null){

            next = curNode.next;

            curNode.next = prev;
            prev = curNode;
            curNode = next;
        }

        return prev;
    }
    public static void main(String[] args) {
        Node linkedList = linkedListReverse.initLinkedList();
        linkedListReverse.showLinkedListByRecursion(linkedList);

        Node reverseListByIteration = linkedListReverse.reverseByIteration(linkedList);
        linkedListReverse.showLinkedList(reverseListByIteration);

        Node reverseListByRecursion = linkedListReverse.reverseByIteration(linkedList);
//        linkedListReverse.showLinkedList(reverseListByIteration);
    }
}
