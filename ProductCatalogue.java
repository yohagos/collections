import java.util.*;


public class ProductCatalogue implements  Iterable<Product> {
    private final Set<Product> products = new HashSet<>();
    public void addSupplier(final Supplier supplier) {
        products.addAll(supplier.getProducts());
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }
}
