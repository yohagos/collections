import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        var door = new Product(1,"wooden door", 35);
        var floorPanel = new Product(2,"wood panel", 5);
        var window = new Product(3, "glass door", 11);

        /*Collection<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);*/

        var shipment = new Shipment();

        shipment.add(door);
        shipment.add(floorPanel);
        shipment.add(window);
        shipment.add(floorPanel);
        shipment.add(window);

        shipment.prepare();

        System.out.println("shipment: ");
        shipment.forEach(System.out::println);

        var lightVanProducts = shipment.getLightVanProducts();
        System.out.println("Light products: ");
        lightVanProducts.forEach(System.out::println);

        // Now we receive an unmodifiable List and therefore can not remove an entry
        // lightVanProducts.remove(window);

        System.out.println("Light products: ");
        lightVanProducts.forEach(System.out::println);

        System.out.println("shipment: ");
        shipment.forEach(System.out::println);
    }

}
