package queue;

public class main {
    public static void main(String[] args) {
        circularQueue test = new circularQueue(30);
        for (int i = 0; i < 30; i++) {
            if (!test.add(i)) System.out.println("can't put!");
        }
        test.show();

        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get());
//            System.out.println("i"+i);
        }
//        test.show();

    }
}
