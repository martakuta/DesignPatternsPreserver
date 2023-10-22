package examples.adapter;

import processor.adapter.AdapterPattern;

@AdapterPattern.ITarget
public interface UserInterface {
    @AdapterPattern.AdapterMethod
    public String getData();
}
