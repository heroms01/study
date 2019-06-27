package designpattern.factory.logistics;

public class Truck implements Transport {
    public void deliver() {
        System.out.println("트럭 배송");
    }
}
