import java.util.Comparator;

public record Product(int id, String name, int weight) {
    @Override
    public String toString() {
        return "Product { id: "+id +", name: "+name+ " , weight: "+weight+" }";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public static final Comparator<Product> BY_WEIGHT = Comparator.comparingInt(Product::weight);
}
