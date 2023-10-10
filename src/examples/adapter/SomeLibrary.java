package examples.adapter;

import processor.adapter.AdapterPattern;

@AdapterPattern.Service
public class SomeLibrary {
    @AdapterPattern.ServiceMethod
    public Integer getData() { return 17; }
}
