import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class CollectionOperations {
    public static Product door = new Product(1, "door", 35);
    public static Product floorPanel = new Product(2, "floor panel", 20);
    public static Product window = new Product(3, "window", 5);

    public static void main(String[] args) {
        /*var products = new ArrayList<>(List.of(door, floorPanel, window));
        System.out.println(products);

        // Collections.rotate(products, 2); // --> changes sequence by distance (int)
        // Collections.shuffle(products); // --> random list of original list
        var alphabet = makeAlphabet();
        System.out.println(alphabet);

        int index = Collections.binarySearch(alphabet, 'M');
        System.out.println(index);*/

        var _1to3 = List.of(1,2,3);
        var _2to4 = List.of(2,3,4);
        var _4to6 = List.of(4,5,6);

        System.out.println(Collections.disjoint(_1to3, _4to6));
        System.out.println(Collections.disjoint(_1to3, _2to4));

        var letters = "ABCDEFAADSEA".chars().mapToObj(x -> (char)x).toList();
        int count = Collections.frequency(letters, 'A');
        System.out.println(count);
    }

    public static List<Character> makeAlphabet() {
        return IntStream.range('A', 'Z').mapToObj(x -> (char)x).toList();
    }
}
