package examples.iterator;

import processor.iterator.IteratorPattern;

@IteratorPattern.ConcreteCollection
public class NameRepository implements IterableCollectionInterface {

    public String names[] = {"Robert" , "John" ,"Julie" , "Lora"};

    @IteratorPattern.CreateIteratorMethod
    @Override
    public Iterator createIterator() {
        return new NameIterator(names);
    }
}