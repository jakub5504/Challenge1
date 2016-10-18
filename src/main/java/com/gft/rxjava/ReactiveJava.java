package com.gft.rxjava;


import com.sun.org.apache.xpath.internal.SourceTree;
import rx.Observable;
import rx.functions.Action1;

public class ReactiveJava {

    public static  void main(String args[]){
        Observable<String> myObservable = Observable.just("Hello World").subscribe(s -> {
            System.out.println(s + " -Dan");});

        myObservable.subscribe(onNextAction);
    }
}
