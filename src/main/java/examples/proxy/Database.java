package examples.proxy;

import processor.proxy.ProxyPattern;

@ProxyPattern.Service
public class Database implements DatabaseInterface {
    @Override
    public int someImportantOperation(int x) {
        return x*5;
    }
}
