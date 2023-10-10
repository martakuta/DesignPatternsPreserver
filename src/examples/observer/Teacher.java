package examples.observer;

import processor.observer.ObserverPattern;

@ObserverPattern.ConcreteSubscriber
public class Teacher implements Reader {

    @ObserverPattern.UpdateMethod
    @Override
    public void buyNewBook(Book book) {
        System.out.println("I'm wondering what about this book is!");
    }
}
