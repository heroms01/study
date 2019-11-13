package com.bestofsky.study.books.rxjavaprogramming.ch2;

import com.bestofsky.study.books.rxjavaprogramming.common.Order;
import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ObservableFromArray {
    public void integerArray() {
        Integer[] arr = {100, 200, 300};
        Observable<Integer> source = Observable.fromArray(arr);
        source.subscribe(System.out::println);
    }

    public void listExample() {
        List<String> names = new ArrayList<>();
        names.add("Jerry");
        names.add("Bob");
        names.add("Mike");

        Observable<String> source = Observable.fromIterable(names);
        source.subscribe(System.out::println);
    }

    public void setExample() {
        Set<String> cities = new HashSet<>();
        cities.add("Seoul");
        cities.add("London");
        cities.add("Paris");

        Observable<String> source = Observable.fromIterable(cities);
        source.subscribe(System.out::println);
    }

    public void blockingQueue() {
        BlockingQueue<Order> orderQueue = new ArrayBlockingQueue<>(10);
        orderQueue.add(new Order("Order 1"));
        orderQueue.add(new Order("Order 2"));
        orderQueue.add(new Order("Order 3"));

        Observable<Order> source = Observable.fromIterable(orderQueue);
        source.subscribe(order -> System.out.println(order));
    }

    public static void main(String[] args) {
        ObservableFromArray observableFromArray = new ObservableFromArray();
        observableFromArray.integerArray();
        observableFromArray.listExample();
        observableFromArray.setExample();
        observableFromArray.blockingQueue();
    }
}
