package toby.live;


import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PubSub {
    public static void main(String[] args) {
        Publisher<Integer> publisher = getPublisher(Stream.iterate(1, a -> a + 1).limit(10).collect(Collectors.toList()));
        publisher.subscribe(getSubscriber());
    }

    private static Subscriber<Integer> getSubscriber() {
        return new Subscriber<Integer>() {

            @Override
            public void onSubscribe(Subscription subscription) {
                System.out.println("onSubscribe");
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext " + integer);
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
    }

    private static Publisher<Integer> getPublisher(final List<Integer> integers) {
        return new Publisher<Integer>() {
            public void subscribe(Subscriber<? super Integer> subscriber) {
                subscriber.onSubscribe(new Subscription() {
                    @Override
                    public void request(long l) {
                        try {
                            integers.forEach(s -> subscriber.onNext(s));
                            subscriber.onComplete();
                        } catch (Throwable throwable) {
                            subscriber.onError(throwable);
                        }
                    }

                    @Override
                    public void cancel() {

                    }
                });
            }
        };
    }

}
