package Patterns.FactoryMethod;

public class Logistic {
    private String product;
    private Transport transport;

    public Logistic(String product, String environment) {
        this.product = product;
        if(environment == "Вода")
            transport = new Ship();
        else if(environment == "Земля")
            transport = new Truck();
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }
}
