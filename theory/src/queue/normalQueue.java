package queue;

public class normalQueue {
    private int front;
    private int rear;
    private int[] queue;
    private int length;

    public normalQueue(int size) {
        length = size;
        queue = new int[length];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return rear == front;

    }

    public boolean isFull() {
        return rear == length - 1;
    }

    public boolean add(int num) {
        if (!isFull()) {
            rear++;
            queue[rear] = num;
            return true;
        } else return false;

    }

    public int get() {
        // pop the last
        if (!isEmpty()) {
//            front++;
            int temp = queue[++front];
            queue[front] = 0;
            return temp;
        } else throw new RuntimeException("nothing can get!");
    }

    public void show() {
        if (!isEmpty()) {
            for (int i = 0; i <= rear; i++) {
                System.out.println("Queue[" + i + "]=" + queue[i]);
            }
        } else System.out.println("[]");

//        return queue[index];
    }

    public int peek() {
        if (!isEmpty()) return queue[front + 1];
        else throw new RuntimeException("empty!");
    }

    public boolean push(int num) {
        // pop the last
        if (!isFull()) {
//            rear++;
            if (rear == length) rear -= length;
            queue[++rear] = num;
            return true;
        } else return false;
    }

    public int pop() {
        // pop the last
        if (!isEmpty()) {
            int temp = queue[rear];
            queue[rear--] = 0;
//            rear--;
            return temp;
        } else throw new RuntimeException("nothing can be pop!");
    }


}
