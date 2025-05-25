import java.util.ArrayList;
import java.util.Scanner;

public class RegularTopping extends Topping {
  String type;
  static ArrayList<Topping> regularToppings;
  static Scanner scanner = new Scanner(System.in);

  public RegularTopping(double price, String type) {
    super(price, type);
    this.type = type; //do I still need this after adding type to the parent class?
  }

  public static ArrayList<Topping> getRegularToppings() {
    return regularToppings;
  }

  // not sure if the arguments are correct in this case because I am not sure if the return is going
  // to be a string or an array list of regular toppings
  public ArrayList<String> setRegularToppings(ArrayList<Topping> toppings) {
    regularToppings = toppings; // took away this.
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "RegularTopping{" + "type='" + type + '\'' + '}';
  }

  public static void printRegularToppings() {
    getRegularToppings();
    for (int i = 0; i < regularToppings.size(); i++) {
      System.out.println(i);
    }
  }
// why is getType() not working here or in PaidTopping?
  public static void selectRegularToppings() {
    System.out.println("Please select any free toppings to add:");
    printRegularToppings();
    ArrayList<Topping> selectedToppings = new ArrayList<>();
    while (true) {
      System.out.println(
          "Please select from the following free toppings by selecting the corresponding number:");
      int choice = scanner.nextInt();
      scanner.nextLine(); // consume line
      try {
        if (choice > 0) {
          Topping selectedTopping =
              regularToppings.get(
                  choice - 1); // translates menu numbering (starting with 1) to java indexing
          // (starting with 0)
          System.out.println("You selected: " + selectedTopping.getType());
          selectedToppings.add(selectedTopping);
          System.out.println("Would you like to add another topping?\nY - yes\nN - no");
          String confirmation = scanner.nextLine();
          if (!confirmation.equalsIgnoreCase("y")) {
            break;
          }
        } else if (choice == 0) { // will this let me end the loop?
          System.out.println("Finished selecting toppings");
          break;
        }

      } catch (IndexOutOfBoundsException e) {
        System.out.println(
            "Invalid input. Please select a number between 0 and " + regularToppings.size() + ".");
      }
    }
  }
}
