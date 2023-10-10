package examples.decorator;

import processor.decorator.DecoratorPattern;

@DecoratorPattern.IComponent
public interface DataSource {
    @DecoratorPattern.ExecuteMethod
    public void writeData(String data);

    @DecoratorPattern.ExecuteMethod
    public String readData();
}
