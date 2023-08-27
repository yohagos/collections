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

        //System.out.println(products);
        //products.removeIf(product -> product.weight() > 20);
        //System.out.println(products);

        Iterator<Product> it = products.iterator();
        while (it.hasNext()) {
            if (it.next().weight() > 20)
                it.remove();
        }
        System.out.println(products.size());
        System.out.println(products.isEmpty());
        System.out.println(products.contains(door));
    }

}
