import java.util.ArrayList;
import java.util.Scanner;

// do I need to extend to all the parts of the sandwich
public class Sandwich {
  static Scanner scanner = new Scanner(System.in);
  private Bread bread;
  private ArrayList<Topping> toppings;
  private boolean toasted;
  private double basePrice;
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

  }

  public Sandwich(Bread bread, boolean toasted, double basePrice, Topping ... toppings) { //added varargs to allow unlimited toppings

    this.bread = bread;
    this.toasted = toasted;
    this.basePrice = basePrice;
    this.toppings = new ArrayList<>(); //initializing list of toppings, should be unlimited
    Size selectedSize = Size.SMALL; //do I need to change this since this needs to be picked by the user?
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

  public double getBasePrice() {
    return basePrice;
  }

  public void setBasePrice(double basePrice) {
    this.basePrice = basePrice;
  }

  public void addTopping(Topping topping) {
    toppings.add(topping);
  }

  public void setSize(Size size) {
    this.size = size;
  }

  public static Sandwich createSandwich(Scanner scanner) {
    // First step to create a sandwich is we initialize a sandwich object
    Sandwich sandwich = new Sandwich();
    // Sandwich needs a size.
    // Ask user for size. I might need to check for invalid size here.
    System.out.println("What size would you like your sandwich?");
    System.out.println("1) 4\"   $5.50\n2) 8\"   $7.00\n3) 12\"   $8.50");
    String size = scanner.nextLine();
    Size sandwichSize = Size.valueOf(size); //idk what this does
    sandwich.setSize(sandwichSize);
    // Sandwich needs bread, ask user
    int userChoice = scanner.nextInt();
    scanner.nextLine(); // consume line
    if (userChoice == 1) {
      size = String.valueOf(Size.SMALL);
    } else if (userChoice == 2) {
      size = String.valueOf(Size.MEDIUM);
    } else if (userChoice == 3){
      size = String.valueOf(Size.LARGE);
    } else {
      System.out.println("Invalid input. Please try again");
      createSandwich(scanner);
      //fix the stack trace error that could happen
    }
    // Initiate bread object, pa
    Bread.selectBread(scanner);

    return null;
  }

  public void addRegularTopping() {}

  public void addDrink() {}

  public void addSauces() {}

  public void addSides() {}
  public static void toastSandwich(boolean toasted) {
    System.out.println("Would you like your sandwich toasted?\n1) Yes\n2) No");
    String userChoice = scanner.nextLine();
    if (userChoice.equals("1") || userChoice.contains("y")) {
      toasted = true;
    } else {
      toasted = false;
    }
  }

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
