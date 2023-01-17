package functionalProgramming.biconsumer;

import java.util.function.BiConsumer;

public class BiConsumerTest {
    /*
    @FunctionalInterface
public interface BiConsumer<T, U> {
  void accept(T t, U u);
}
     */


    public static void main(String[] args) {

        BiConsumer<Integer,Integer> integerIntegerBiConsumer = (a1, a2)-> System.out.println(a1+a2);
        integerIntegerBiConsumer.accept(1,3);

        addTwo(1, 2, (x, y) -> System.out.println(x + y));          // 3
        addTwo("Node", ".js", (x, y) -> System.out.println(x + y)); // Node.js
        
    }

    static <T> void addTwo(T a1, T a2, BiConsumer<T, T> c) {
        c.accept(a1, a2);
    }

}
