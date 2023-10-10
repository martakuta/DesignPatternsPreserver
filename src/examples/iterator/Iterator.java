package examples.iterator;

import processor.iterator.IteratorPattern;

@IteratorPattern.IIterator
public interface Iterator {
    @IteratorPattern.HasNextMethod
    public boolean hasNext();
    @IteratorPattern.NextMethod
    public Object next();
}