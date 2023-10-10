package examples.adapter;

import processor.adapter.AdapterPattern;

@AdapterPattern.IClient
public interface UserInterface {
    @AdapterPattern.AdapterMethod
    public String getData();
}
