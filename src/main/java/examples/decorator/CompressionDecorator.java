package examples.decorator;

import processor.decorator.DecoratorPattern;

@DecoratorPattern.ConcreteDecorator
public class CompressionDecorator extends DataSourceDecorator {

    public CompressionDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @DecoratorPattern.ExecuteMethod
    public void writeData(String data) {
        super.writeData(data+"compress");
    }

    @DecoratorPattern.ExecuteMethod
    public String readData() {
        return super.readData()+"decompress";
    }
}
