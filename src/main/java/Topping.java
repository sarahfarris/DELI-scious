// represent a single topping
public class Topping {
  double price;
  String type;
  String size; //not sure if I want this here because of enums

//do I need name and type?
    public Topping(double price, String type) {
//took out name since name and type were the same thing
        this.price = price;
        this.type = type;
        this.size = size;

    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Sandwich.Size getSize() {
        return Sandwich.Size.valueOf(size); //this was a suggestion from intelliJ
    }

    public void setSize(String size) {
        this.size = size;
    }
}

    // name
    // price (price)
    // Sandwich.Size enum
    // getter setter/one constructor
    // paid topping and free topping is gonna extend this class
    // free topping constructor going to set the price 0 using the super constructor
    // paid topping..... price using Sandwich.Size (similar to bread constructor) and  use the superconstructor to build the object



