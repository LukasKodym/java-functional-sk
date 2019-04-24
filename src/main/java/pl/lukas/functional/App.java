package pl.lukas.functional;

public class App {

    public static void main(String[] args) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("A");
            }
        };

        Runnable ru = () -> System.out.println("A");

        Comparable<String> c = new Comparable<String>() {
            @Override
            public int compareTo(String o) {
                return 0;
            }
        };

        Comparable<String> co =  o -> 0;

        Movable m = direction -> 11;
    }
}