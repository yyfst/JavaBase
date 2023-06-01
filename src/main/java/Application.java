import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Application {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i * i);
        }

        Iterator<Integer> iterator = list.iterator();
        iterator.forEachRemaining(System.out::println);
    }
}
