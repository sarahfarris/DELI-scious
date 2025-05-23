import java.util.ArrayList;
import java.util.Scanner;

public class RegularToppings implements Topping {
  String type;
  static ArrayList<Topping> regularToppings;
  static Scanner scanner = new Scanner(System.in);

  public RegularToppings(String type) {
    this.type = type;
  }

  public static ArrayList<Topping> getRegularToppings() {
    return regularToppings;
  }

  //not sure if the arguments are correct in this case because I am not sure if the return is going to be a string or an array list of regular toppings
  public ArrayList<String> setRegularToppings(ArrayList<Topping> toppings) {
    regularToppings = toppings; //took away this.
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

  public static void printRegularToppings() {
    for (int i = 0; i < regularToppings.size(); i++) {
      System.out.println(i);
    }
  }

  public static void selectRegularToppings() {
    System.out.println("Please select any free toppings to add:");
    getRegularToppings();
  }
}
