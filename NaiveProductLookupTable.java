import java.util.ArrayList;
import java.util.List;

public abstract class NaiveProductLookupTable implements ProductLookupTable {
    /*
    * NOT RECOMMENDED, ITS ONLY AN EXAMPLE!!!
    * FOR THOSE KIND OF PROCEDURES, IT IS RECOMMENDED TO USE
    * Maps or HashMaps.
    *
    * */
    private final List<Product> products = new ArrayList<>();

    @Override
    public void addProduct(final Product productToAdd) {
        var id = productToAdd.getId();
        for (Product product: products) {
            if (product.getId() == id) {
                throw new IllegalArgumentException("duplicate id for " + product);
            }
        }
    }

    @Override
    public Product lookupById(final int id) {
        for (var product: products ) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        products.clear();
    }
}
