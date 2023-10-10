package examples.decorator;

import processor.decorator.DecoratorPattern;

@DecoratorPattern.BaseDecorator
public class DataSourceDecorator implements DataSource {
    @DecoratorPattern.WrappeeField
    private DataSource wrappee;

    public DataSourceDecorator (DataSource dataSource) {
        this.wrappee = dataSource;
    }

    @Override
    @DecoratorPattern.ExecuteMethod
    public void writeData(String data) {
        wrappee.writeData(data);
    }

    @Override
    @DecoratorPattern.ExecuteMethod
    public String readData() {
        return wrappee.readData();
    }
}
