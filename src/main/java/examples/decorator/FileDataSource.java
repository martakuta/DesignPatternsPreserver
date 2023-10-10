package examples.decorator;

import processor.decorator.DecoratorPattern;

@DecoratorPattern.ConcreteComponent
public class FileDataSource implements DataSource {

    @Override
    @DecoratorPattern.ExecuteMethod
    public void writeData(String data) {
        System.out.println("WRITE: " + data);
    }

    @Override
    @DecoratorPattern.ExecuteMethod
    public String readData() {
        return "";
    }
}
