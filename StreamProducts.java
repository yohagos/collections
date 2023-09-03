import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamProducts {
    public static void main(String[] args) {
        var door = new Product(1, "door", 35);
        var floorPanel = new Product(2, "floor panel", 25);
        var window = new Product(3, "window", 10);

        var products = List.of(door, floorPanel, window, floorPanel, window, floorPanel);

        //System.out.println(namesOfLightProductsWeightSortedLoop(products));
        //System.out.println(namesOfLightProductsWeightSortedStreams(products));

        // Example for .collect() and Collectors functions
        var result = products.stream()
                .filter(product -> product.getWeight() < 30)
                .sorted(Comparator.comparingInt(Product::getWeight))
                .collect(Collectors.groupingBy(Product::getName, Collectors.counting()));

        System.out.println("results: " + result);
    }

    private static List<String> namesOfLightProductsWeightSortedStreams(List<Product> products) {
        /*  .stream()   -> creates a Stream of a List
            .filter()   -> defining filter options
            .sorted()   -> sort new List with Comparator options
            .map()      -> generates a new Stream of Objects,
                           could be primitive types, inherited objects
                           or super class with fewer fields
            .distinct() -> removes duplicate entries
            .toList()   -> creates a list of the stream
        */

        return products
                .stream()
                .filter(product -> product.getWeight() < 30)
                .sorted(Comparator.comparingInt(Product::getWeight))
                .map(Product::getName).distinct().toList();
    }

    private static  List<String> namesOfLightProductsWeightSortedLoop(List<Product> products) {
        List<Product> lightProducts = new ArrayList<>();
        for( Product product: products) {
            if (product.getWeight() < 30)
                lightProducts.add(product);
        }
        lightProducts.sort(Comparator.comparingInt(Product::getWeight));

        List<String> productNames = new ArrayList<>();
        for (Product product: lightProducts) {
            productNames.add(product.getName());
        }

        return Collections.unmodifiableList(productNames);
    }

    /*
    * NOTE: Primitive Streams
    * For performance there are also Stream functionalities for primitive Data Types 'long', 'int' and 'double'.
    * Boxed Numerics like 'Integer' have a bit of overhead for simple processes
    *
    * Examples:
    * strings.mapToInt(String::length)
    * IntStream.of(1,2)
    * IntStream.range(start, end)
    * */

    /*
    * NOTE: Parallel Streams
    * Streams which can be run in parallel mode. Run on the common fork-join pool (threads pool) of the JVM
    * Not always a performance improvement
    * */

    /*
    * Conclusion to Streams vs. Loops
    * Streams:
    * - High level construct
    * - Optimized framework
    * - General better readability
    * - Some corner cases worse
    *
    * Loops:
    * - Low level construct
    * - Can be faster (in some cases)
    * - Readability is subjective
    * - Nicer with checked Exceptions
    * */
}
