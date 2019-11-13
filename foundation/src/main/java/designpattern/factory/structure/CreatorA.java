package designpattern.factory.structure;

public class CreatorA extends Creator {
    public Product createProduct() {
        return new ProductA();
    }
}
