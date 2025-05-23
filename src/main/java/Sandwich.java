import java.util.ArrayList;
import java.util.Scanner;

// do I need to extend to all the parts of the sandwich
public class Sandwich {
  static Scanner scanner = new Scanner(System.in);
  private Bread bread;
//  private String size;
  private ArrayList<Topping> toppings;
   static boolean toasted;
  private double basePrice;

  public Sandwich(Bread bread, boolean toasted, double basePrice, Topping ... toppings) { //added varargs to allow unlimited toppings

    this.bread = bread;
    this.toasted = toasted;
    this.basePrice = basePrice;
    this.toppings = new ArrayList<>(); //initializing list of toppings, should be unlimited
  }

  public boolean isToasted() {
    return toasted;
  }

  public void setToasted(boolean toasted) {
    this.toasted = toasted;
  }

//  public String getSize() {
//    return size;
//  }

//  public void setSize(String size) {
//    this.size = size;
//  }

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

  public static void addTopping() {
    PaidTopping.selectPaidToppings();
    RegularToppings.selectRegularToppings();
  }

  public static Sandwich createSandwich(Scanner scanner) {
    Bread.selectSize(scanner);
    Bread.selectBread(scanner);
    addTopping();
    toastSandwich(toasted);
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
