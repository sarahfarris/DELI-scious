import java.util.InputMismatchException;
import java.util.Scanner;

public class Drink extends MenuItem {
  Flavor flavor;
  static Scanner scanner = new Scanner(System.in);
  Size size;

  enum Size {
    SMALL,
    MEDIUM,
    LARGE;
  }

  enum Flavor {
    COKE("Coke"),
    DIETCOKE("Diet Coke"),
    SPRITE("Sprite"),
    DRPEPPER("Dr. Pepper"),
    FANTAORANGE("Fanta Orange"),
    ROOTBEER("Root Beer"),
    POWERADE("Powerade"),
    LEMONADE("Lemonade"),
    HICORANGE("Hi-C Orange"),
    WATER("Water bottle");

    private final String name;
    private Flavor(String name) {
      this.name = name;
    }
  }

  public Drink(Size size, Flavor flavor) {
    this.size = size;
    this.flavor = flavor;
    switch (size) {
      case SMALL -> price = 2.00;
      case MEDIUM -> price = 2.50;
      case LARGE -> price = 3.00;
    }
  }

  public Flavor getFlavor() {
    return flavor;
  }

  public void setFlavor(Flavor flavor) {
    this.flavor = flavor;
  }

  public double getDrinkPrice() {
    return super.getPrice();
  }

  public static Drink addDrink(Scanner scanner) {
    Drink drink;
    Flavor flavor = null;
    Size size = null;

    boolean pickSize = true;
    while (pickSize) {
      System.out.println("What size would you like?");
      System.out.println("1) Small     $2.00\n2) Medium     $2.50\n3) Large     3.00");
      try {
        int userChoice = scanner.nextInt();
        scanner.nextLine(); // consume line
        if (userChoice == 1) {
          size = Size.SMALL;
          pickSize = false;
        } else if (userChoice == 2) {
          size = Size.MEDIUM;
          pickSize = false;
        } else if (userChoice == 3) {
          size = Size.LARGE;
          pickSize = false;
        }
      } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a number 1 through 3.");
        scanner.nextLine(); // prevents loop running infinitely, updates the invalid input in the
        // scanner
      }
    }

    boolean pickFlavor = true;
    while (pickFlavor) {
      System.out.println("What flavor Choice drink?");
      System.out.println(
          "1) Coke\n2) Diet Coke\n3) Sprite\n4) Dr. Pepper\n5) Fanta Orange\n6) Root Beer\n7) Powerade\n8) Lemonade\n9) Hi-C Orange\n0) Water Bottle");
      try {
        int flavorChoice = scanner.nextInt();
        if (flavorChoice == 1) {
          flavor = Flavor.COKE;
        } else if (flavorChoice == 2) {
          flavor = Flavor.DIETCOKE;
        } else if (flavorChoice == 3) {
          flavor = Flavor.SPRITE;
        } else if (flavorChoice == 4) {
          flavor = Flavor.DRPEPPER;
        } else if (flavorChoice == 5) {
          flavor = Flavor.FANTAORANGE;
        } else if (flavorChoice == 6) {
          flavor = Flavor.ROOTBEER;
        } else if (flavorChoice == 7) {
          flavor = Flavor.POWERADE;
        } else if (flavorChoice == 8) {
          flavor = Flavor.LEMONADE;
        } else if (flavorChoice == 9) {
          flavor = Flavor.HICORANGE;
        } else if (flavorChoice == 0) {
          flavor = Flavor.WATER;
        }
        pickFlavor = false;
      } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please select a number from the list to pick your flavor:");
        scanner.nextLine(); //prevents infinite looping
      }
    }
    drink = new Drink(size, flavor);
    drink.setFlavor(flavor);
    drink.setItemDescription();
    System.out.println(drink);

    return drink;
  }

  @Override
  public String toString() {
    // Uses the getName() from MenuItem, which is set by the constructor.
    // If you want to use the flavor's name directly, you can use flavor.name
    return flavor.name + " (" + size.toString() + ") - $" + String.format("%.2f", getPrice());
  }

  public void setItemDescription() {
    // Format for receipt: Name (Size) Price
    itemDescription = String.format("%-25s $%.2f%n", flavor.name + " (" + size.toString() + ")", getPrice());
  }
}
