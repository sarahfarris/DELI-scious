import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// do I need to extend to all the parts of the sandwich
public class Sandwich extends MenuItem {
  static Scanner scanner = new Scanner(System.in);
  private String name;
  private Bread bread;
  private ArrayList<Topping> toppings =
      new ArrayList<>(); // fixes null pointer exception when displaying premade sandwiches
  private boolean toasted;
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

    @Override
    public String toString() {
      return inches + "\""; // Example: "4\"", "8\"", "12\""
    }
  }

  public Sandwich() {}

  public boolean isToasted() {
    return toasted;
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

  public void setSize(Size size) {
    this.size = size;
  }

  public void addTopping(String name) {
    toppings.add(Topping.getSpecificTopping(name, size));
  }

  public void addAllToppings(ArrayList<Topping> allToppings) {
    if (toppings.isEmpty()) {
      toppings = allToppings;
    } else {
      toppings.addAll(allToppings);
    }
  }

  public static Sandwich addSandwich(Scanner scanner) {
    // Ask user what sandwich would they like
    Sandwich sandwich = new Sandwich(); // changed from null
    Sandwich blt = Sandwich.createBLT();
    Sandwich cheeseSteak = Sandwich.createPhillyCheeseSteak();
    Sandwich veggie = Sandwich.createVeggieDelight();
    Sandwich italian = Sandwich.createItalianSub();
    System.out.println("Pick from the following options: ");
    System.out.println("----------------------------------");
    System.out.println("Signature Sandwiches:");
    System.out.println("A: " + blt);
    System.out.println("----------------------------------");
    System.out.println("B: " + cheeseSteak);
    System.out.println("----------------------------------");
    System.out.println("C: " + veggie);
    System.out.println("----------------------------------");
    System.out.println("D: " + italian);
    System.out.println("----------------------------------");
    System.out.println("E: Custom sandwich");
    System.out.println("----------------------------------");
    // print the premade sandwiches with the menu format
    scanner.nextLine(); // consume line
    String userChoice = scanner.nextLine();


    // Make a while loop here for incorrect input
    try {
      if (userChoice.equalsIgnoreCase("a")) {
        sandwich = createBLT();
      } else if (userChoice.equalsIgnoreCase("b")) {
        sandwich = createPhillyCheeseSteak();
      } else if (userChoice.equalsIgnoreCase("c")) {
        sandwich = createVeggieDelight();
      } else if (userChoice.equalsIgnoreCase("d")) {
        sandwich = createItalianSub();
      } else if (userChoice.equalsIgnoreCase("e")) {
        sandwich = createCustomSandwich(scanner);
      }
    } catch (NullPointerException e) {
      throw new RuntimeException("No sandwich to be added.");
    }

    sandwich.modifySandwich();
    sandwich.calculateSandwichPrice();
    sandwich.setItemDescription();
    return sandwich;
  }

  public static Sandwich createCustomSandwich(Scanner scanner) {
    Sandwich sandwich = new Sandwich();
    sandwich.name = "Custom Sandwich";
    boolean creatingSandwich = true;
    while (creatingSandwich) {
      try {
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
        // sandwich building logic
        sandwich.setSize(size);
        sandwich.setBread(Bread.createBread(scanner, size));
        ArrayList<Topping> allToppings = Topping.askUserForToppings(size);
        sandwich.addAllToppings(allToppings);
        sandwich.toastSandwich();
        sandwich.calculateSandwichPrice();
        System.out.println(sandwich.toppings);
        sandwich.setItemDescription();
        // itemDescription = good representation of the sandwich (with toppings) + price
        System.out.println(sandwich); // prints out the selected toppings
        creatingSandwich = false;
      } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please select an option between 1 and 3.");
        scanner.nextLine();
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
      } else if (userChoice.equalsIgnoreCase("n") || userChoice.equals("2")) {
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

  // sandwich modification
  public void modifySandwich() {
    // modifying sandwich
    boolean modifying = true;
    while (modifying) {
      try {
        System.out.println(
            "Would you like to add or remove any toppings?\nA - Add topping\nR - Remove topping\n0 - Continue to Checkout");
        String userConfirmation = scanner.nextLine();
        System.out.println("userConf: " + userConfirmation);
        System.out.println("sandwich " + this);
        if (userConfirmation.equalsIgnoreCase("a")) {
          ArrayList<Topping> addonToppings = Topping.askUserForToppings(size);
          addAllToppings(addonToppings);
        } else if (userConfirmation.equalsIgnoreCase("r")) {
          Topping.removeToppingsFromSandwich(size, toppings);
        } else if (userConfirmation.equalsIgnoreCase("0")) {
          modifying = false;
        } else {
          System.out.println("Invalid input. Please input a corresponding number.");
        }
      } catch (IndexOutOfBoundsException r) {
        System.out.println("That number is not valid.");
      } catch (RuntimeException e) {
        System.out.println("Invalid input. Please try again.");
      }
    }
  }

  // prints signature sandwich toppings
  public static List<Topping> getAllAvailableToppingsForSize(Size size) {
    Topping.initializeFreeToppings();
    Topping.initializePaidToppings(size);

    List<Topping> allAvailable = new ArrayList<>();
    allAvailable.addAll(Topping.allFreeToppings);
    allAvailable.addAll(Topping.allPaidToppings);
    return allAvailable;
  }

  public static Sandwich createBLT() {
    Size size = Size.MEDIUM;
    Bread bread = new Bread(size, "White"); // 8" white bread
    //    ArrayList<Topping> bltToppings = new ArrayList<>();
    Sandwich blt = new Sandwich();
    blt.name = "BLT";
    blt.setSize(size);
    blt.toasted = true;
    blt.setBread(bread);

    // Add toppings
    blt.addTopping("Bacon");
    blt.addTopping("Cheddar");
    blt.addTopping("Lettuce");
    blt.addTopping("Tomatoes");
    blt.addTopping("Ranch");

    blt.calculateSandwichPrice();
    return blt;
  }

  public static Sandwich createPhillyCheeseSteak() {
    Size size = Size.MEDIUM;
    Bread bread = new Bread(size, "White"); // 8" white bread

    Sandwich philly = new Sandwich();
    philly.name = "Philly Cheesesteak";
    philly.setSize(size);
    philly.toasted = true;
    philly.setBread(bread);

    // Add toppings
    philly.addTopping("Steak");
    philly.addTopping("American");
    philly.addTopping("Peppers");
    philly.addTopping("Mayo");

    philly.calculateSandwichPrice();
    return philly;
  }

  public static Sandwich createVeggieDelight() {
    Size size = Size.SMALL;
    Bread bread = new Bread(size, "wheat");

    Sandwich veggie = new Sandwich();
    veggie.name = "Veggie Delight";
    veggie.setSize(size);
    veggie.setBread(bread);
    veggie.toasted = false;

    // Add toppings
    veggie.addTopping("Lettuce");
    veggie.addTopping("Tomatoes");
    veggie.addTopping("Onions");
    veggie.addTopping("Cucumbers");
    veggie.addTopping("Swiss"); // Swiss cheese
    veggie.addTopping("Vinaigrette");

    veggie.calculateSandwichPrice();
    return veggie;
  }

  public static Sandwich createItalianSub() {
    Size size = Size.LARGE;
    Bread bread = new Bread(size, "Rye");

    Sandwich italian = new Sandwich();
    italian.name = "Italian";
    italian.setBread(bread);
    italian.setSize(size);
    italian.toasted = false;

    // Add toppings
    italian.addTopping("Salami");
    italian.addTopping("Ham"); // Assuming ham is part of Italian
    italian.addTopping("Provolone");
    italian.addTopping("Lettuce");
    italian.addTopping("Onions");
    italian.addTopping("Peppers");
    italian.addTopping("Vinaigrette");

    italian.calculateSandwichPrice();
    return italian;
  }

  @Override
  public String toString() {
    if (name == null || name.isEmpty()) {
      return "";
    }
    calculateSandwichPrice();
    StringBuilder sb = new StringBuilder();
    sb.append(name).append(" (").append(size.getInches()).append("\")\n"); // Name (Size)
    sb.append("Bread: ").append(bread.getBreadType());
    if (toasted) {
      sb.append(" (Toasted)");
    }
    sb.append("\n");

    sb.append("Topping: "); // Start the topping line
    if (toppings.isEmpty()) {
      sb.append("None");
    } else {
      for (int i = 0; i < toppings.size(); i++) {
        sb.append(toppings.get(i).toString()); // Uses Topping's toString (Name ($Price))
        if (i < toppings.size() - 1) {
          sb.append(", "); // Add comma and space between toppings
        }
      }
    }
    sb.append("\n"); // Newline after toppings

    sb.append("Total price: $").append(String.format("%.2f", getPrice()));
    return sb.toString();
  }

  // Method to get a string representation suitable for a receipt
  public void setItemDescription() {
    calculateSandwichPrice();
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("%-25s $%.2f%n", name + " (" + size.getInches() + "\")", getPrice()));
    sb.append(String.format("  - Bread: %s %s%n", bread.getBreadType(), (toasted ? "(Toasted)" : "")));

    if (!toppings.isEmpty()) {
      sb.append("  - Toppings:%n");
      for (Topping topping : toppings) {
        // Only show price if it's not zero for toppings on the receipt line
        if (topping.getPrice() > 0) {
          sb.append(String.format("    - %-18s $%.2f%n", topping.getName(), topping.getPrice()));
        } else {
          sb.append(String.format("    - %s%n", topping.getName()));
        }
      }
    }
    itemDescription = sb.toString();
  }
}
