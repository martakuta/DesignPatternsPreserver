package examples.iterator;

import processor.iterator.IteratorPattern;

@IteratorPattern.ICollection
public interface IterableCollectionInterface {
    @IteratorPattern.CreateIteratorMethod
    Iterator createIterator();
}