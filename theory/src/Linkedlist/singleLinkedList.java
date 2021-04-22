package Linkedlist;

public class singleLinkedList {
    public static void main(String[] args) {
        node hero1 = new node(1, "宋江", "及时雨");
        node hero2 = new node(2, "卢俊义", "玉麒麟");
        node hero3 = new node(3, "林冲", "豹子头");

        list Ryan = new list();
        Ryan.add(hero1);
        Ryan.add(hero2);
        Ryan.add(hero3);

        Ryan.show();
    }
}

class list {
    private node head = new node(0, "", "");

    private node tail = head;

    public void add(node node_) {
//        node temp = head;
//        while(true) if(temp.next==null) break;
//
//        temp = temp.next;
        tail.next = node_;
        tail = node_;
    }

    public void show() {
        if (head.next == null) return;
        else {
            node temp = head.next;
            while (temp != null) {
                System.out.println(temp);
                temp = temp.next;

            }
        }
    }

}

class node {
    public String name;
    private String nickname;
    public int id;
    public node next;

    public node(int id, String name, String nickname) {
        this.name = name;
        this.id = id;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "id:" + id + "name" + name + "nickname" + nickname;
    }

}