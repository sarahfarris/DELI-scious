public class MenuItem {
//    took out name
    double price;

    public MenuItem(double price) {
//        this.name = name;
        this.price = price;
    }

//    public String getName() {
//        return name;
//    }

//    public void setName(String name) {
//        this.name = name;
//    }

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
