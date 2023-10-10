package examples.decorator;

import processor.decorator.DecoratorPattern;

@DecoratorPattern.ConcreteDecorator
public class EncryptionDecorator extends DataSourceDecorator {

    public EncryptionDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @DecoratorPattern.ExecuteMethod
    public void writeData(String data) {
        super.writeData(data+"encrypted");
    }

    @DecoratorPattern.ExecuteMethod
    public String readData() {
        return super.readData()+"decrypt";
    }
}
