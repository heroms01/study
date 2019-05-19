package factory.logistics;

public class SeaLogistics extends Logistics {

    public Transport createTransport() {
        return new Ship();
    }
}
