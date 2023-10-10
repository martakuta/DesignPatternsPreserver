package examples.adapter;

import processor.adapter.AdapterPattern;

@AdapterPattern.Adapter
public class LibraryAdapter implements UserInterface {

    @AdapterPattern.AdapteeServiceField
    private SomeLibrary library;
    @AdapterPattern.AdapterMethod
    public String getData() {
        Integer libraryData = library.getData();
        return libraryData.toString();
    }
}
