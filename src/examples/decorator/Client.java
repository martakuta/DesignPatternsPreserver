package examples.decorator;

public class Client {
    public static void main(String[] args) {
        DataSourceDecorator encoded = new CompressionDecorator(new EncryptionDecorator(new FileDataSource()));
        encoded.writeData("hello");
        System.out.println(encoded.readData());
    }
}
