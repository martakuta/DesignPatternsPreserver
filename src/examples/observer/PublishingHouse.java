package examples.observer;

import processor.observer.ObserverPattern;

import java.util.ArrayList;

@ObserverPattern.Publisher
public class PublishingHouse {
    @ObserverPattern.SubscribersField
    private ArrayList<Reader> readingClubMembers;

    public PublishingHouse() {
        this.readingClubMembers = new ArrayList<>();
    }

    @ObserverPattern.SubscribeMethod
    public void joinTheReadingClub(Reader reader) {
        this.readingClubMembers.add(reader);
    }

    @ObserverPattern.UnsubscribeMethod
    public void leaveTheReadingClub(Reader reader) {
        this.readingClubMembers.remove(reader);
    }

    @ObserverPattern.NotifyMethod
    public void publishBook() {
        Book book = new Book();
        for (Reader reader : this.readingClubMembers) {
            reader.buyNewBook(book);
        }
    }
}
