package factory.structure;

public class CreatorB extends Creator {
    public Product createProduct() {
        return new ProductB();
    }
}
