public class MenuItem {
//    took out name
    double price;

    public MenuItem(double price) {
        this.price = price;
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
