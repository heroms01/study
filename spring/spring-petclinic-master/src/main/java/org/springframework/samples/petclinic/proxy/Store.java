package org.springframework.samples.petclinic.proxy;

public class Store {
    Payment payment;

    public Store(Payment payment) {
        this.payment = payment;
    }

    public void buy(int amount) {
        payment.pay(amount);
    }
}
