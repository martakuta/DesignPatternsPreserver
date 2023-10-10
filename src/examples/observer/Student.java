package examples.observer;

import processor.observer.ObserverPattern;

@ObserverPattern.ConcreteSubscriber
public class Student implements Reader {

    @ObserverPattern.UpdateMethod
    @Override
    public void buyNewBook(Book book) {
        System.out.println("What an amazing book!");
    }
}
