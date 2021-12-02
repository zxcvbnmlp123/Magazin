public class Sanitary extends Product {


    public Sanitary(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Sanitary{" +
                "ID='" + id + '\'' +
                "name='" + name + '\'' +
                "price='" + price + '\'' +
                "quantity='" + quantity + '\'' +
                '}';
    }
}
