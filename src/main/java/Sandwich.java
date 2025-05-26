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

  public Sandwich() {}

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

  public void addAllToppings(ArrayList<Topping> allToppings) {
    this.toppings = allToppings;
  }

  public static Sandwich createSandwich(Scanner scanner) {
    Sandwich sandwich = new Sandwich();
    System.out.println("What size would you like your sandwich?");
    System.out.println("1) 4\"   $5.50\n2) 8\"   $7.00\n3) 12\"   $8.50");
    Size size;
    while (true) {
      int userChoice = scanner.nextInt();
      scanner.nextLine(); // consume line
      if (userChoice == 1) {
        size = Size.SMALL;
        break;
      } else if (userChoice == 2) {
        size = Size.MEDIUM;
        break;
      } else if (userChoice == 3) {
        size = Size.LARGE;
        break;
      } else {
        System.out.println("Invalid input. Please try again");
      }
    }
    sandwich.setSize(size);
    sandwich.setBread(Bread.createBread(scanner, size));
    ArrayList<Topping> allToppings = Topping.getToppings(size);
    System.out.println(allToppings);
    sandwich.addAllToppings(allToppings);
    sandwich.toastSandwich();
    return sandwich;
  }

  public void toastSandwich() {
    System.out.println("Would you like your sandwich toasted?\n1) Yes\n2) No");
    String userChoice = scanner.nextLine();
    if (userChoice.equals("1") || userChoice.contains("y")) {
       toasted = true;
    } else {
      toasted = false;
    }
  }

  public double calculateSandwichPrice() {
    double totalSandwichPrice = bread.getPrice() + Topping.getToppings()
    return 0.0;
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
