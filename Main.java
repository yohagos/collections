import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var door = new Product("wooden door", 15);
        var floorPanel = new Product("wood panel", 5);

        Product[] products = {door, floorPanel};
        System.out.println(Arrays.toString((products)));

        var window = new Product("glass window", 10);
        products = add(window, products);
        System.out.println("Added new Product: "+Arrays.toString((products)));

        products = add(window, products);
        System.out.println("Added new Product: "+Arrays.toString((products)));
    }

    static Product[] add(Product toAdd, Product[] array) {
        int length = array.length;
        var newArray = Arrays.copyOf(array, length+1);
        newArray[length] = toAdd;
        return newArray;
    }
}
