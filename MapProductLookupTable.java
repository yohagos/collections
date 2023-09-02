import java.util.HashMap;
import java.util.Map;

public abstract class MapProductLookupTable implements ProductLookupTable{
    private final Map<Integer, Product> idToProduct = new HashMap<>();

    @Override
    public void addProduct(final Product product) {
        var id = product.getId();
        if (idToProduct.putIfAbsent(id, product) != null)
            throw new IllegalArgumentException("duplicate id for "+product);
    }

    @Override
    public Product lookupById(final int id) {
        return idToProduct.get(id);
    }

    @Override
    public void clear() {
        idToProduct.clear();
    }

}
