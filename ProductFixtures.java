public enum ProductFixtures {
    door(new Product(1, "door", 25)),
    floorPanel(new Product(2, "floor panel", 19)),
    window(new Product(3, "window", 15)),

    defaultProduct(new Product(-1, "test", 100))
    ;

    private Product product;

    @Override
    public String toString() {
        return product.toString();
    }

    ProductFixtures(Product product) {
        this.product = product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
