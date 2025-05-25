import java.util.ArrayList;
import java.util.Scanner;

public class PaidTopping extends Topping {
  String type;
  static ArrayList<Topping> paidToppings;
  static Scanner scanner = new Scanner(System.in);
  ArrayList<Topping> paidTopping;
  // do I need the size attribute here and in the constructor, so I can have a getter/setter so it will be detected in the selectToppings methods?
  Sandwich.Size size;

  public PaidTopping(double price, String type, Sandwich.Size size) {
    super(price, type);
    this.type = type;// do i still need this?
    this.size = size; // added this so getSize() will work in selectedToppings
  }

  public static ArrayList<Topping> getPaidToppings() {
    if (paidToppings == null || paidToppings.isEmpty()) {
      paidToppings = new ArrayList<>(); // initializing, changed this from setPaidToppings();
    }
    return paidToppings;
  }


  public String getType() {
    return type;
  }


  public void setType(String type) {
    this.type = type;
  }


  public double getPrice() {
    return price;
  }


  public void setPrice(double price) {
    this.price = price;
  }


  public Sandwich.Size getSize() {
    return size;
  }

  public void setSize(Sandwich.Size size) {
    this.size = size;
  }

  @Override
  public String toString() {
    return "PaidTopping{"
        + "type='"
        + type
        + " | "
        + ", price="
        + " $"
        + String.format("%.2f", price)
        + '}';
  }
//this used to have Topping as the parameter instead of the arraylist
  public void setPaidToppings(ArrayList<Topping> paidTopping) {
    this.paidTopping = paidTopping;
  }
//    paidToppings = new ArrayList<>(); // list initialization
//    paidToppings.add(new PaidTopping("steak", "4\"", 1.00));
//    paidToppings.add(new PaidTopping("steak", "8\"", 2.00));
//    paidToppings.add(new PaidTopping("steak", "12\"", 3.00));
//    paidToppings.add(new PaidTopping("steak +", "4\"", 1.50));
//    paidToppings.add(new PaidTopping("steak +", "8\"", 3.00));
//    paidToppings.add(new PaidTopping("steak +", "12\"", 4.50));
//
//    paidToppings.add(new PaidTopping("ham", "4\"", 1.00));
//    paidToppings.add(new PaidTopping("ham", "8\"", 2.00));
//    paidToppings.add(new PaidTopping("ham", "12\"", 3.00));
//    paidToppings.add(new PaidTopping("ham +", "4\"", 1.50));
//    paidToppings.add(new PaidTopping("ham +", "8\"", 3.00));
//    paidToppings.add(new PaidTopping("ham +", "12\"", 4.50));
//
//    paidToppings.add(new PaidTopping("salami", "4\"", 1.00));
//    paidToppings.add(new PaidTopping("salami", "8\"", 2.00));
//    paidToppings.add(new PaidTopping("salami", "12\"", 3.00));
//    paidToppings.add(new PaidTopping("salami +", "4\"", 1.50));
//    paidToppings.add(new PaidTopping("salami +", "8\"", 3.00));
//    paidToppings.add(new PaidTopping("salami +", "12\"", 4.50));
//
//    paidToppings.add(new PaidTopping("roast beef", "4\"", 1.00));
//    paidToppings.add(new PaidTopping("roast beef", "8\"", 2.00));
//    paidToppings.add(new PaidTopping("roast beef", "12\"", 3.00));
//    paidToppings.add(new PaidTopping("roast beef +", "4\"", 1.50));
//    paidToppings.add(new PaidTopping("roast beef +", "8\"", 3.00));
//    paidToppings.add(new PaidTopping("roast beef +", "12\"", 4.50));
//
//    paidToppings.add(new PaidTopping("chicken", "4\"", 1.00));
//    paidToppings.add(new PaidTopping("chicken", "8\"", 2.00));
//    paidToppings.add(new PaidTopping("chicken", "12\"", 3.00));
//    paidToppings.add(new PaidTopping("chicken +", "4\"", 1.50));
//    paidToppings.add(new PaidTopping("chicken +", "8\"", 3.00));
//    paidToppings.add(new PaidTopping("chicken +", "12\"", 4.50));
//
//    paidToppings.add(new PaidTopping("bacon", "4\"", 1.00));
//    paidToppings.add(new PaidTopping("bacon", "8\"", 2.00));
//    paidToppings.add(new PaidTopping("bacon", "12\"", 3.00));
//    paidToppings.add(new PaidTopping("bacon +", "4\"", 1.50));
//    paidToppings.add(new PaidTopping("bacon +", "8\"", 3.00));
//    paidToppings.add(new PaidTopping("bacon +", "12\"", 4.50));
//
//    paidToppings.add(new PaidTopping("american", "4\"", 0.75));
//    paidToppings.add(new PaidTopping("american", "8\"", 1.50));
//    paidToppings.add(new PaidTopping("american", "12\"", 2.25));
//    paidToppings.add(new PaidTopping("american +", "4\"", 1.05));
//    paidToppings.add(new PaidTopping("american +", "8\"", 2.10));
//    paidToppings.add(new PaidTopping("american +", "12\"", 3.15));
//
//    paidToppings.add(new PaidTopping("provolone", "4\"", 0.75));
//    paidToppings.add(new PaidTopping("provolone", "8\"", 1.50));
//    paidToppings.add(new PaidTopping("provolone", "12\"", 2.25));
//    paidToppings.add(new PaidTopping("provolone +", "4\"", 1.05));
//    paidToppings.add(new PaidTopping("provolone +", "8\"", 2.10));
//    paidToppings.add(new PaidTopping("provolone +", "12\"", 3.15));
//
//    paidToppings.add(new PaidTopping("cheddar", "4\"", 0.75));
//    paidToppings.add(new PaidTopping("cheddar", "8\"", 1.50));
//    paidToppings.add(new PaidTopping("cheddar", "12\"", 2.25));
//    paidToppings.add(new PaidTopping("cheddar +", "4\"", 1.05));
//    paidToppings.add(new PaidTopping("cheddar +", "8\"", 2.10));
//    paidToppings.add(new PaidTopping("cheddar +", "12\"", 3.15));
//
//    paidToppings.add(new PaidTopping("swiss", "4\"", 0.75));
//    paidToppings.add(new PaidTopping("swiss", "8\"", 1.50));
//    paidToppings.add(new PaidTopping("swiss", "12\"", 2.25));
//    paidToppings.add(new PaidTopping("swiss +", "4\"", 1.05));
//    paidToppings.add(new PaidTopping("swiss +", "8\"", 2.10));
//    paidToppings.add(new PaidTopping("swiss +", "12\"", 3.15));
//  }

  public static void printPaidToppings() {
    getPaidToppings();
    System.out.println("Available paid toppings: ");
    if (paidToppings == null || paidToppings.isEmpty()) {
      setPaidToppings(paidToppings); // initializing
    }
    if (paidToppings.isEmpty()) {
      System.out.println("Initialization failed.");
      return;
    }

    for (int i = 0; i < paidToppings.size(); i++) {
      System.out.println(
          (i + 1)
              + ". "
              + paidToppings.get(
                  i));
    }
  }

  public static ArrayList<Topping> selectPaidToppings() {
    printPaidToppings();
    ArrayList<Topping> selectedToppings = new ArrayList<>();
    while (true) {
      System.out.println(
          "Please select from the following paid toppings by selecting the corresponding number:");
      int choice = scanner.nextInt();
      scanner.nextLine(); // consume line
      try {
        if (choice > 0) {
          Topping selectedTopping =
              paidToppings.get(
                  choice
                      - 1); // translates menu numbering (starting with 1) to java indexing
                            // (starting with 0)
          System.out.println(
              "You selected: "
                  + selectedTopping.getType()
                  + selectedTopping.getSize()
                  + " for $"
                  + selectedTopping.getPrice());
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
            "Invalid input. Please select a number between 0 and " + paidToppings.size() + ".");
      }
      // TODO: calculate cost of sandwich and display summary, have ability to go to home screen to
      // add other items to order
    }
    return selectedToppings;
  }
}
