public class Food extends Product {

    public String expireDate;


    public Food(int id, String name, double price, int quantity, String expireDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expireDate = expireDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "Food{" +
                "ID='" + id + '\'' +
                "name='" + name + '\'' +
                "price='" + price + '\'' +
                "quantity='" + quantity + '\'' +
                "expireDate='" + expireDate + '\'' +
                '}';
    }
}
