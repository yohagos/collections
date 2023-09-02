import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        var door = new Product("wooden door", 35);
        var floorPanel = new Product("wood panel", 5);
        var window = new Product("glass door", 11);

        Collection<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);


    }

}
