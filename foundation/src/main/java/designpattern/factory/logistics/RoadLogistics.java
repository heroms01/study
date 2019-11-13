package designpattern.factory.logistics;

public class RoadLogistics extends Logistics {
    public Transport createTransport() {
        return new Truck();
    }
}
