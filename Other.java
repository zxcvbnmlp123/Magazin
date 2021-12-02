public class Other extends Product {

    String color;

    public Other(int id, String name, double price, int quantity, String color) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Other{" +
                "ID='" + id + '\'' +
                "name='" + name + '\'' +
                "price='" + price + '\'' +
                "quantity='" + quantity + '\'' +
                "color='" + color + '\'' +
                '}';
    }
}
