package 이것이자바다.chapter6;

public class Singleton {
    private Singleton() {
        System.out.println("Singleton Constructor");
    }

    static {
        System.out.println("Singleton class loaded");
    }

    private static class Holder {
        static {
            System.out.println("Holder class loaded");
        }

        static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }

    public static void dummyMethod() {
        System.out.println("Dummy method called");
    }

    public static void main(String[] args) {
        System.out.println("Main started");
        // Singleton.getInstance();
    }
}
