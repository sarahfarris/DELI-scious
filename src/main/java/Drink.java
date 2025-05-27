import java.util.ArrayList;
import java.util.Scanner;

public class Drink {
  String flavor; // create array list of flavors
  double drinkPrice;
  static Scanner scanner = new Scanner(System.in);

  enum DrinkSize {
    SMALL,
    MEDIUM,
    LARGE;
  }
//do I really need Scanner in the constructor?
  public Drink(Scanner scanner, DrinkSize size) {
    switch (size) {
      case SMALL -> drinkPrice = 2.00;
      case MEDIUM -> drinkPrice = 2.50;
      case LARGE -> drinkPrice = 3.00;
    }
  }

  public String getFlavor() {
    return flavor;
  }

  public void setFlavor(String flavor) {
    this.flavor = flavor;
  }

  public double getDrinkPrice() {
    return drinkPrice;
  }

  public void setDrinkPrice(double drinkPrice) {
    this.drinkPrice = drinkPrice;
  }

  public static Drink addDrink(Scanner scanner, DrinkSize size) {
    Drink drink = new Drink(scanner, size);
    System.out.println("What size would you like?");
    System.out.println("1) Small     $2.00\n2)Medium     $2.50\n3)Large     3.00");
    int userChoice = scanner.nextInt();
    scanner.nextLine(); // consume line, have not tested this to find out if I need it yet
    if (userChoice == 1) {
      drink.setDrinkPrice
    }

    ArrayList<Drink> drinks = new ArrayList<>();
  }
}
