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

    /*
    * SortedSet
    * - Defines an order
    * - No indexes. but subset views possible
    *
    * E first();
    * E last();
    *
    * SortedSet tailSet(E fromElement);
    * SortedSet headSet(E fromElement);
    * SortedSet subSet(E fromElement, E toElement);
    * */

    /*
    * NavigableSet
    * - Extends SortedSet
    * - Provides ways to move through the order
    * - Implemented by TreeSet
    *
    * E lower();
    * E higher();
    *
    * E floor(E e);
    * E ceiling(E e);
    *
    * E pollFirst(); --> returns Value, but removes it from Set
    * E pollLast(); --> returns Value, but removes it from Set
    * */
}
