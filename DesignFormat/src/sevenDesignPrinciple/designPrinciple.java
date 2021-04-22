package sevenDesignPrinciple;

/**
 * @author Ryan
 * @date 2020/9/6 16:04
 */
public class designPrinciple {

    public static void main(String[] args) {
        SingleInstance instance_1 = SingleInstance.getInstance();
        SingleInstance instance_2 = SingleInstance.getInstance();
        System.out.println(instance_1.hashCode() == instance_2.hashCode());

    }
}

//class SingleInstance {
//    private SingleInstance(){
//
//    }
//    private final static SingleInstance instance;
//    static {
//        instance = new SingleInstance();
//    }
//    public static SingleInstance getInstance(){
//        return instance;
//    }
//}

class SingleInstance {
    private SingleInstance() {

    }

    private static volatile SingleInstance instance;

    public static synchronized SingleInstance getInstance() {
        if (instance == null) {
            synchronized (SingleInstance.class) {
                if (instance == null) {
                    instance = new SingleInstance();
                }
            }
        }
        return instance;
    }
}
