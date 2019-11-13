package designpattern.factory.structure;

public abstract class Creator {
    public void someOperation() {
        Product product = createProduct();
        product.doStuff();
    }

    public abstract Product createProduct();
}
