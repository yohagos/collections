import java.util.HashMap;
import java.util.Map;

public class ViewerOverMaps {

    public static void main(String[] args) {
        var idToProduct = new HashMap<Integer, ProductFixtures>();
        idToProduct.put(1, ProductFixtures.door);
        idToProduct.put(2, ProductFixtures.floorPanel);
        idToProduct.put(3, ProductFixtures.window);



        System.out.println(idToProduct);
        var result = idToProduct.computeIfAbsent(10, key -> {
            return ProductFixtures.defaultProduct;
        });
        //idToProduct.replaceAll((key, oldValue) -> new Product(oldValue.getProduct().getId(), oldValue.getProduct().getName(), oldValue.getProduct().getWeight()+50));
        System.out.println(idToProduct);

        /*System.out.println(idToProduct);
        System.out.println(idToProduct.getOrDefault(10, ProductFixtures.defaultProduct));
        System.out.println(idToProduct.get(10));*/
        /*
        ENTRY SET FUNCTIONS

            var entries = idToProduct.entrySet();
            var e = entries.iterator().next();
            e.setValue(null);
            //for( var entry: entries)
                //System.out.println(entry);
            idToProduct.forEach((id, product) -> System.out.println(product));

            var entries = idToProduct.entrySet();
            var entry = Map.entry(1, ProductFixtures.door);
            entries.remove(entry);
            System.out.println(entries);
            System.out.println(idToProduct);
        */

        /*
        EFFICIENT REMOVE OPERATION

        var products = idToProduct.values();
        products.remove(ProductFixtures.door);
        idToProduct.remove(2);
        System.out.println(products);
        */

        /*
        KEYSET EXAMPLE

        var ids = idToProduct.keySet();
        ids.add(4);
        System.out.println(ids);
        System.out.println(idToProduct);
        */


    }
}
