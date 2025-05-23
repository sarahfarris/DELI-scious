import java.util.ArrayList;

public class RegularToppings implements Topping {
  String type;

  public RegularToppings(String type) {
    this.type = type;
  }

  public static void getRegularToppings() {
    ArrayList<Topping> regularToppings = new ArrayList<>();
  }

  public ArrayList<String> setRegularToppings() {
    ArrayList<String> regularToppings = new ArrayList<>();
    regularToppings.add("lettuce");
    regularToppings.add("peppers");
    regularToppings.add("onions");
    regularToppings.add("tomatoes");
    regularToppings.add("jalapenos");
    regularToppings.add("cucumbers");
    regularToppings.add("pickles");
    regularToppings.add("guacamole");
    regularToppings.add("mushrooms");
    return regularToppings;
  }

  @Override
  public String getType() {
    return "";
  }

  @Override
  public void setType(String type) {}

  @Override
  public String getSize() {
    return "";
  }

  @Override
  public void setSize(String size) {}

  @Override
  public double getPrice() {
    return 0;
  }

  @Override
  public void setPrice(double price) {}

  @Override
  public String toString() {
    return "RegularToppings{" + "type='" + type + '\'' + '}';
  }

  public static void selectRegularToppings() {
    System.out.println("Please select any free toppings to add:");
    getRegularToppings();
  }
}
