

public class MenuItem {
    String name;
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
    public String getItemDescription(){
        return itemDescription;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                 '\'' +
                ", price=" + price +
                '}';
    }
}
