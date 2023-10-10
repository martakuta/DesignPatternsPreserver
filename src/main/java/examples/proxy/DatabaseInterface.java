package examples.proxy;

import processor.proxy.ProxyPattern;

@ProxyPattern.IService
public interface DatabaseInterface {
    int someImportantOperation(int x);
}
