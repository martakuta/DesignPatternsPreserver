package examples.observer;

import processor.observer.ObserverPattern;

@ObserverPattern.ISubscriber
public interface Reader {

    @ObserverPattern.UpdateMethod
    void buyNewBook(Book book);
}
