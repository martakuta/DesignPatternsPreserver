package examples.adapter;

import processor.adapter.AdapterPattern;

@AdapterPattern.AdapteeService
public class SomeLibrary {
    @AdapterPattern.ServiceMethod
    public Integer getData() { return 17; }
}
