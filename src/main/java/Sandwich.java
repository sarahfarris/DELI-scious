import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

// do I need to extend to all the parts of the sandwich
public class Sandwich extends MenuItem {
  static Scanner scanner = new Scanner(System.in);
  private Bread bread;
  private ArrayList<Topping> toppings;
  private boolean toasted;
  private double price;
  private Size size;

  public enum Size {
    SMALL(4),
    MEDIUM(8),
    LARGE(12);

    private final int inches; // Field to store the size in inches

    // Constructor to initialize the 'inches' field for each enum constant
    private Size(int inches) {
      this.inches = inches;
    }

    // Public getter method to retrieve the 'inches' value
    public int getInches() {
      return inches;
    }

    // You can also override toString() for a custom string representation
    @Override
    public String toString() {
      return inches + "\""; // Example: "4\"", "8\"", "12\""
    }
  }

  public Sandwich() {
    super(0.0);
  }

  public boolean isToasted() {
    return toasted;
  }

  public void setToasted(boolean toasted) {
    this.toasted = toasted;
  }

  public Bread getBread() {
    return bread;
  }

  public void setBread(Bread bread) {
    this.bread = bread;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void addTopping(Topping topping) {
    toppings.add(topping);
  }

  public void setSize(Size size) {
    this.size = size;
  }

  public void addAllToppings(ArrayList<Topping> allToppings) {
    this.toppings = allToppings;
  }

  public static Sandwich createSandwich(Scanner scanner) {
    Sandwich sandwich = new Sandwich();
    System.out.println("What size would you like your sandwich?");
    System.out.println("1) 4\"   $5.50\n2) 8\"   $7.00\n3) 12\"   $8.50");
    Size size = null;

    int userChoice = scanner.nextInt();
    scanner.nextLine(); // consume line
    if (userChoice == 1) {
      size = Size.SMALL;

    } else if (userChoice == 2) {
      size = Size.MEDIUM;

    } else if (userChoice == 3) {
      size = Size.LARGE;

    } else {
      System.out.println("Invalid input. Please try again");
    }

    sandwich.setSize(size);
    sandwich.setBread(Bread.createBread(scanner, size));
    ArrayList<Topping> allToppings = Topping.getToppings(size);
    sandwich.addAllToppings(allToppings);
    sandwich.toastSandwich();
    sandwich.calculateSandwichPrice();
    System.out.println(
        "Sandwich price: "
            + sandwich.getPrice()
            + "\nToppings selected: "
            + sandwich.toppings); // prints out the selected toppings

    // sandwich modification
    boolean modifying = true;
    while (modifying) {
      System.out.println(
          "Would you like to add or remove any toppings?\nA - Add topping\nR - Remove topping\n0 - Continue to Checkout");
      String userConfirmation = scanner.nextLine();
      if (userConfirmation.equalsIgnoreCase("a")) {
        //need to print both options to add toppings from both lists
        Topping.getCustomerSelectedToppings(size); // made public to call here
        Topping.printToppingsMenuForSize(Topping.allPaidToppings, size);
        Topping.getCustomerSelectedFreeToppings(size);
//        Topping.printToppingsMenuForSize(Topping.allFreeToppings, size);

      } else if (userConfirmation.equalsIgnoreCase("r")) {
        Topping.removeToppingsFromSandwich(size, sandwich.toppings);
      } else if (userConfirmation.equalsIgnoreCase("0")) {
        // checkout
        modifying = false;
      } else {
        System.out.println("Invalid input. Please try again.");
      }
    }
      return sandwich;
  }

  public void toastSandwich() {
    System.out.println("Would you like your sandwich toasted?\n1) Yes\n2) No");
    String userChoice = scanner.nextLine();
    boolean toasting = true;
    while (toasting) {
      if (userChoice.equals("1") || userChoice.contains("y")) {
        toasted = true;
        toasting = false;
      } else if (userChoice.equalsIgnoreCase("n")) {
        toasted = false;
        toasting = false;
      } else {
        System.out.println("Invalid input. Please try again.");
      }
    }
    }

  private void calculateSandwichPrice() {
    double totalSandwichPrice = bread.getPrice();
    for (int i = 0; i < toppings.size(); i++) {
      Topping t = toppings.get(i);
      totalSandwichPrice += t.getPrice();
    }
    price = totalSandwichPrice;
  }

  // may need to edit the toString method to match updates
  @Override
  public String toString() {
    return "Sandwich{"
        + "bread='"
        + bread
        + '\''
        + ", toppings="
        + toppings
        + ", toasted="
        + toasted
        + '}';
  }
}
