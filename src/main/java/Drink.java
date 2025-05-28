import java.util.InputMismatchException;
import java.util.Scanner;

public class Drink {
  Flavor flavor;
  double drinkPrice;
  static Scanner scanner = new Scanner(System.in);
  private Size size;

  enum Size {
    SMALL,
    MEDIUM,
    LARGE;
  }

  enum Flavor {
    COKE,
    DIETCOKE,
    SPRITE,
    DRPEPPER,
    FANTAORANGE,
    ROOTBEER,
    POWERADE,
    LEMONADE,
    HICORANGE,
    WATER;
  }

  public Drink(Size size, Flavor flavor) {
    this.size = size;
    this.flavor = flavor;
    switch (size) {
      case SMALL -> drinkPrice = 2.00;
      case MEDIUM -> drinkPrice = 2.50;
      case LARGE -> drinkPrice = 3.00;
    }
    flavor =
        switch (flavor) {
          case COKE -> Drink.Flavor.COKE; // this is the only way I can get ENUMS to work
          case DIETCOKE ->
              Drink.Flavor.DIETCOKE; // need to modify so it prints with string formatting (captial
          // letters and spaces)
          case SPRITE -> Drink.Flavor.SPRITE;
          case DRPEPPER -> Drink.Flavor.DRPEPPER;
          case FANTAORANGE -> Drink.Flavor.FANTAORANGE;
          case ROOTBEER -> Drink.Flavor.ROOTBEER;
          case POWERADE -> Drink.Flavor.POWERADE;
          case LEMONADE -> Drink.Flavor.LEMONADE;
          case HICORANGE -> Drink.Flavor.HICORANGE;
          case WATER -> Drink.Flavor.WATER;
        };
  }

  public Flavor getFlavor() {
    return flavor;
  }

  public void setFlavor(Flavor flavor) {
    this.flavor = flavor;
  }

  public double getDrinkPrice() {
    return drinkPrice;
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
        scanner.nextLine(); // consume line, have not tested this to find out if I need it yet
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
          "1) Coke\n2) Diet Coke\n3) Sprite\n4) Dr. Pepper\n5) Fanta Orange\n6) Root Beer\n7) Powerade\n8) Lemonade\n9) Hi-C Orange\n0) Water");
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
    System.out.println("Drink: " + drink.getFlavor().toString().toLowerCase() + " $" + drink.getDrinkPrice());
    return drink;
  }
}
