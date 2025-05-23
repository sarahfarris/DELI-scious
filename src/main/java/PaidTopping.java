import java.util.ArrayList;
import java.util.Scanner;

public class PaidTopping implements Topping {
  String type;
  String size;
  double price;
  static ArrayList<Topping> paidToppings;
  static Scanner scanner = new Scanner(System.in);

  public PaidTopping(String type, String size, double price) {
    this.type = type;
    this.size = size;
    this.price = price;
  }

  public static ArrayList<Topping> getPaidToppings() {
    if (paidToppings == null || paidToppings.isEmpty()) {
      setPaidToppings(); //initializing
    }
    return paidToppings;
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String getSize() {
    return size;
  }

  @Override
  public void setSize(String size) {
    this.size = size;
  }

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "PaidTopping{"
        + "type='"
        + type
        + " | "
        + ", size='"
        + size
        + " | "
        + ", price="
        + " $"
        + String.format("%.2f", price)
        + '}';
  }

  public static void setPaidToppings() {
//    paidToppings = toppings; //took away this.
    paidToppings = new ArrayList<>();
    paidToppings.add(new PaidTopping("steak", "4\"", 1.00));
    paidToppings.add(new PaidTopping("steak", "8\"", 2.00));
    paidToppings.add(new PaidTopping("steak", "12\"", 3.00));
    paidToppings.add(new PaidTopping("steak +", "4\"", 1.50));
    paidToppings.add(new PaidTopping("steak +", "8\"", 3.00));
    paidToppings.add(new PaidTopping("steak +", "12\"", 4.50));

    paidToppings.add(new PaidTopping("ham", "4\"", 1.00));
    paidToppings.add(new PaidTopping("ham", "8\"", 2.00));
    paidToppings.add(new PaidTopping("ham", "12\"", 3.00));
    paidToppings.add(new PaidTopping("ham +", "4\"", 1.50));
    paidToppings.add(new PaidTopping("ham +", "8\"", 3.00));
    paidToppings.add(new PaidTopping("ham +", "12\"", 4.50));

    paidToppings.add(new PaidTopping("salami", "4\"", 1.00));
    paidToppings.add(new PaidTopping("salami", "8\"", 2.00));
    paidToppings.add(new PaidTopping("salami", "12\"", 3.00));
    paidToppings.add(new PaidTopping("salami +", "4\"", 1.50));
    paidToppings.add(new PaidTopping("salami +", "8\"", 3.00));
    paidToppings.add(new PaidTopping("salami +", "12\"", 4.50));

    paidToppings.add(new PaidTopping("roast beef", "4\"", 1.00));
    paidToppings.add(new PaidTopping("roast beef", "8\"", 2.00));
    paidToppings.add(new PaidTopping("roast beef", "12\"", 3.00));
    paidToppings.add(new PaidTopping("roast beef +", "4\"", 1.50));
    paidToppings.add(new PaidTopping("roast beef +", "8\"", 3.00));
    paidToppings.add(new PaidTopping("roast beef +", "12\"", 4.50));

    paidToppings.add(new PaidTopping("chicken", "4\"", 1.00));
    paidToppings.add(new PaidTopping("chicken", "8\"", 2.00));
    paidToppings.add(new PaidTopping("chicken", "12\"", 3.00));
    paidToppings.add(new PaidTopping("chicken +", "4\"", 1.50));
    paidToppings.add(new PaidTopping("chicken +", "8\"", 3.00));
    paidToppings.add(new PaidTopping("chicken +", "12\"", 4.50));

    paidToppings.add(new PaidTopping("bacon", "4\"", 1.00));
    paidToppings.add(new PaidTopping("bacon", "8\"", 2.00));
    paidToppings.add(new PaidTopping("bacon", "12\"", 3.00));
    paidToppings.add(new PaidTopping("bacon +", "4\"", 1.50));
    paidToppings.add(new PaidTopping("bacon +", "8\"", 3.00));
    paidToppings.add(new PaidTopping("bacon +", "12\"", 4.50));

    paidToppings.add(new PaidTopping("american", "4\"", 0.75));
    paidToppings.add(new PaidTopping("american", "8\"", 1.50));
    paidToppings.add(new PaidTopping("american", "12\"", 2.25));
    paidToppings.add(new PaidTopping("american +", "4\"", 1.05));
    paidToppings.add(new PaidTopping("american +", "8\"", 2.10));
    paidToppings.add(new PaidTopping("american +", "12\"", 3.15));

    paidToppings.add(new PaidTopping("provolone", "4\"", 0.75));
    paidToppings.add(new PaidTopping("provolone", "8\"", 1.50));
    paidToppings.add(new PaidTopping("provolone", "12\"", 2.25));
    paidToppings.add(new PaidTopping("provolone +", "4\"", 1.05));
    paidToppings.add(new PaidTopping("provolone +", "8\"", 2.10));
    paidToppings.add(new PaidTopping("provolone +", "12\"", 3.15));

    paidToppings.add(new PaidTopping("cheddar", "4\"", 0.75));
    paidToppings.add(new PaidTopping("cheddar", "8\"", 1.50));
    paidToppings.add(new PaidTopping("cheddar", "12\"", 2.25));
    paidToppings.add(new PaidTopping("cheddar +", "4\"", 1.05));
    paidToppings.add(new PaidTopping("cheddar +", "8\"", 2.10));
    paidToppings.add(new PaidTopping("cheddar +", "12\"", 3.15));

    paidToppings.add(new PaidTopping("swiss", "4\"", 0.75));
    paidToppings.add(new PaidTopping("swiss", "8\"", 1.50));
    paidToppings.add(new PaidTopping("swiss", "12\"", 2.25));
    paidToppings.add(new PaidTopping("swiss +", "4\"", 1.05));
    paidToppings.add(new PaidTopping("swiss +", "8\"", 2.10));
    paidToppings.add(new PaidTopping("swiss +", "12\"", 3.15));
  }

  public static void printPaidToppings() {
    for (int i = 0; i < paidToppings.size(); i++) {
      System.out.println(i);
    }
  }

  public static void selectPaidToppings() {
    System.out.println("Please select from the following paid toppings:");
    printPaidToppings();
    String userPaidTopping = scanner.nextLine();
    //create a string builder to be able to add multiple toppings
  }
}
