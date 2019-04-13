package toby.live;

import java.util.Arrays;
import java.util.concurrent.Flow;

import static java.util.concurrent.Flow.*;

public class PubSub {
    public static void main(String[] args) {
        Iterable<Integer> itr = Arrays.asList(1, 2, 3, 4, 5);

        Publisher publisher = new Publisher() {
            @Override
            public void subscribe(Subscriber subscriber) {
                subscriber.onSubscribe(new Subscription() {
                    @Override
                    public void request(long n) {

                    }

                    @Override
                    public void cancel() {

                    }
                });
            }
        };

        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Integer item) {
                System.out.println("onNext"+item);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        publisher.subscribe(subscriber);
    }
}
