public class Makeup extends Product {
    public String expireDate;
    public String color;

    public Makeup(int id, String name, double price, int quantity, String expireDate, String color) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expireDate = expireDate;
        this.color = color;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Makeup{" +
                "ID='" + id + '\'' +
                "name='" + name + '\'' +
                "price='" + price + '\'' +
                "quantity='" + quantity + '\'' +
                "expireDate='" + expireDate + '\'' +
                "color='" + color + '\'' +
                '}';
    }
}
