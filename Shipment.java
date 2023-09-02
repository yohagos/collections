import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Shipment implements Iterable<Product>{
    private static final int MISSING_PRODUCT = -1;

    private static final int LIGHT_VAN_MAX_WEIGHT = 20;


    private final List<Product> products = new ArrayList<>();
    private List<Product> lightVanProducts;
    private List<Product> heavyVanProducts;

    public void add(Product product) {
        this.products.add(product);
    }

    public boolean replace(Product oldProduct, Product newProduct) {
        /* int position = products.indexOf(oldProduct);
        if (position == -1) {
            return false;
        } else {
            products.set(position, newProduct);
            return true;
        }*/
        boolean update = products.contains(oldProduct);
        if (update) {
            products.replaceAll(product -> product == oldProduct ? newProduct : product);
        }
        return update;
    }

    public void prepare() {
        // Sort the product list
        products.sort(Product.BY_WEIGHT);

        // find the split point
        int splitPoint = findSplitPoint();

        // create two subviews of the list
        lightVanProducts = products.subList(0, splitPoint);
        heavyVanProducts = products.subList(splitPoint, products.size());
    }

    private int findSplitPoint() {
        int size = products.size();
        for (int i = 0; i < size; i++) {
            var product = products.get(i);
            if (product.weight() > LIGHT_VAN_MAX_WEIGHT)
                return i;
        }
        return products.size();
    }

    public List<Product> getLightVanProducts() {
        return lightVanProducts;
    }

    public List<Product> getHeavyVanProducts() {
        return heavyVanProducts;
    }

    public boolean stripHeavyProducts() {
        return products.removeIf(product -> product.weight() > LIGHT_VAN_MAX_WEIGHT);
    }

    public Iterator<Product> iterator() {
        return products.iterator();
    }
}
