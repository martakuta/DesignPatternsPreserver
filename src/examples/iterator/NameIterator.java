package examples.iterator;

import processor.iterator.IteratorPattern;

@IteratorPattern.ConcreteIterator
public class NameIterator implements Iterator {

    int index;
    public String[] names;

    NameIterator(String[] names) {
        this.names = names;
    }

    @IteratorPattern.HasNextMethod
    @Override
    public boolean hasNext() {
        return index < names.length;
    }

    @IteratorPattern.NextMethod
    @Override
    public Object next() {
        if(this.hasNext()){
            return names[index++];
        }
        return null;
    }
}
