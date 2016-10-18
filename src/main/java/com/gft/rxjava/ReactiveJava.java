package com.gft.rxjava;



import rx.Observable;

public class ReactiveJava {

    public static  void main(String args[]){
        Observable.just("Hello World")
                .map(s -> s + " -Dan ")
                .map(String::hashCode)
                .map(i -> Integer.toString(i))
                .subscribe(System.out::println);

    }
}
