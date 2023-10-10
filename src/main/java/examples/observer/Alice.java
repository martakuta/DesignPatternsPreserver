package examples.observer;

import processor.observer.ObserverPattern;

@ObserverPattern.ConcreteSubscriber
public class Alice extends Student {
    @ObserverPattern.UpdateMethod
    @Override
    public void buyNewBook(Book book) {
        System.out.println("I'm Alice. What an amazing book!");
    }
}
