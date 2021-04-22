package queue;


public class circularQueue {
    private int front;
    private int rear;
    private int[] queue;
    private int length;

    public circularQueue(int size) {
        length = size;
        queue = new int[length];
        front = 0; // 第一个元素
        rear = 0; // 最后一个元素再空出来一个
    }

    public boolean isEmpty() {
        return rear == front; //最后空出来的空间可以避免isEmpty与isFull区分
    }

    public boolean isFull() {
        return (rear + 1) % length == front;
    }

    public boolean add(int num) {
        if (!isFull()) {
//            rear++;
            queue[rear] = num;
            rear = (rear + 1) % length;
            return true;
        } else return false;

    }

    public int get() {
        // pop the last
        if (!isEmpty()) {
//            front++;
//            System.out.println("front"+front);
            int temp = queue[front];
//            queue[front]=0;
            front = (front + 1) % length;

            return temp;
        } else throw new RuntimeException("nothing can get!");
    }

    public int size() {
        return (rear + length - front) % length;
    }

    public void show() {
        if (!isEmpty()) {
            for (int i = front; i < front + size(); i++) {
                int index = i % length;
                System.out.println("Queue[" + index + "]=" + queue[index]);
            }
        } else System.out.println("[]");

//        return queue[index];
    }

    public int peek() {
        if (!isEmpty()) return queue[front];
        else throw new RuntimeException("empty!");
    }
//    public boolean push(int num) {
//        // pop the last
//        if(!isFull()){
////            rear++;
//            if(rear==length) rear-=length;
//            queue[++rear]=num;
//            return true;
//        }
//        else return false;
//    }
//
//    public int pop() {
//        // pop the last
//        if(!isEmpty()){
//            int temp = queue[rear];
//            queue[rear--]=0;
////            rear--;
//            return temp;
//        }
//        else throw new RuntimeException("nothing can be pop!");
//    }


}
