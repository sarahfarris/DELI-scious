public class MenuItem {
//    took out name
    String itemDescription;
    double price;

    public MenuItem() {
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                 '\'' +
                ", price=" + price +
                '}';
    }
}
