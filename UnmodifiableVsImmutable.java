import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UnmodifiableVsImmutable {
    public static void main (String[] args) {
        var mutableCountryToPopulation = new HashMap<>();
        mutableCountryToPopulation.put("UK", 67);
        mutableCountryToPopulation.put("USA", 328);
        mutableCountryToPopulation.put("Wesex", null);

        var unmodifiable = Collections.unmodifiableMap(mutableCountryToPopulation);

        var copied = Map.copyOf(unmodifiable); //copyOf does not accept null values
        var mutableCopy = new HashMap<>(mutableCountryToPopulation);

        System.out.println("mutableCountryToPopulation = "+mutableCountryToPopulation);
        System.out.println("unmodifiable = "+ unmodifiable);
        System.out.println("copied = "+copied);

        /*System.out.println("mutableCountryToPopulation = "+mutableCountryToPopulation);
        System.out.println("unmodifiable = "+ unmodifiable);
        System.out.println("copied = "+copied);

        // Both not possible, unmodifiable and it will result in an exception
        // unmodifiable.put("japan", 60);
        // copied.put("Spain", 80);

        System.out.println("PUT");
        mutableCountryToPopulation.put("Germany", 83);

        System.out.println("mutableCountryToPopulation = "+mutableCountryToPopulation);
        System.out.println("unmodifiable = "+ unmodifiable);
        System.out.println("copied = "+copied);*/

        // Factory Methods do not accept Null values, throws NullPointerException
        /*var countryToPopulation = Map.of("UK", 60, "USA", 328);
        System.out.println(countryToPopulation);
        countryToPopulation.put("GER", 83);*/

        /*
        * FACTORY METHODS:
        * - Empty Collections
        * List<String> list = Collections.emptyList()       -> empty list
        * Map<Integer, String> map = Collections.emptyMap() -> empty Map
        * Set<Integer> set = Collections.emptySet()         -> empty Set
        *
        * - Singletons (only one value)
        * List<String> list = Collections.singletonList("one")          -> empty list
        * Map<Integer, String> map = Collections.singletonMap(1, "one") -> empty Map
        * Set<Integer> set = Collections.singletonSet(1)                -> empty Set
        *
        * 'var' keyword produce overhead for a collection with less than 10 entries
        *
        * List<String> list = List.of("UK", "USA")
        * Map<String, Integer> map = Map.of("UK", 60, "USA", 328)
        * Map<String, Integer> entries = Map.ofEntries(
        *   Map.entry("UK", 60),
        *   Map.entry("USA", 328)
        * )
        *
        * Immutable Copies
        * List<String> countries = new ArrayList<>();
        * countries.add("UK");
        * countries.add("USA");
        * List<String> immutableCopy = List.copyOf(countries); -> immutable
        *
        * Map<String, Integer> population = new HashMap<>();
        * population.add("UK", 60);
        * population.add("USA", 328);
        * Map<String, Integer> immutableCopy = Map.copyOf(population); -> immutable
        *
        * Unmodifiable Views
        * List<String> countries = new ArrayList<>();
        * countries.add("UK");
        * countries.add("USA");
        * List<String> countriesView = Collection.unmodifiableList(countries); -> unmodifiable
        *
        * Map<String, Integer> population = new HashMap<>();
        * population.add("UK", 60);
        * population.add("USA", 328);
        * Map<String, Integer> populationView = Collection.unmodifiableMap(population); -> unmodifiable
        *
        * ---> unmodifiable views = Data can be changed in their classes,
        *                           but views will be returned which can not be modified
        * */
    }
}
