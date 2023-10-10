package examples.singleton;

import processor.singleton.SingletonPattern;

@SingletonPattern.Singleton
public class Database {

    private int databaseKey;
    @SingletonPattern.InstanceField
    private static Database instance;

    @SingletonPattern.SingletonConstructor
    private Database() {
        databaseKey = 1;
    }

    @SingletonPattern.GetInstanceMethod
    public Database getDatabase() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

}
