package pl.lukas.functional;

public class App {

    public static void main(String[] args) {

        Runnable ru = () -> System.out.println("A");
        Runnable run = () -> System.out.println("B");

        test("A", ru);
        test("B", run);

    }

    public static void test(String name, Runnable a) {

    }
}