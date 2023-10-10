package examples.proxy;

import processor.proxy.ProxyPattern;

@ProxyPattern.Proxy
public class DatabaseProxy implements DatabaseInterface {
    @ProxyPattern.RealServiceField
    private Database database;

    DatabaseProxy() {
        database = new Database();
    }

    @Override
    public int someImportantOperation(int x) {
        int y = x*10;
        int z = database.someImportantOperation(y);
        return z+3;
    }
}
