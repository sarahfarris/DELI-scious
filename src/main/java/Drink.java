import java.util.Scanner;

public class Drink{
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
 flavor = switch (flavor) {
      case COKE -> Drink.Flavor.COKE; //this is the only way I can get ENUMS to work
      case DIETCOKE -> Flavor.valueOf("Diet Coke");// need to modify so it prints with string formatting (captial letters and spaces)
      case SPRITE -> Flavor.valueOf("Sprite");
      case DRPEPPER -> Flavor.valueOf("Dr. Pepper");
      case FANTAORANGE -> Flavor.valueOf("Fanta Orange");
      case ROOTBEER -> Flavor.valueOf("Root Beer");
      case POWERADE -> Flavor.valueOf("Powerade");
      case LEMONADE -> Flavor.valueOf("Lemonade");
      case HICORANGE -> Flavor.valueOf("Hi-C Orange");
      case WATER -> Flavor.valueOf("Water");
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
    System.out.println("What size would you like?");
    System.out.println("1) Small     $2.00\n2) Medium     $2.50\n3) Large     3.00");
    Drink drink;
    Flavor flavor;
    Size size = null;
    while (true) {
      int userChoice = scanner.nextInt();
      scanner.nextLine(); // consume line, have not tested this to find out if I need it yet
      if (userChoice == 1) {
        size = Size.SMALL;
      } else if (userChoice == 2) {
        size = Size.MEDIUM;
      } else if (userChoice == 3) {
        size = Size.LARGE;
      } else {
        System.out.println("Invalid input. Please try again.");
      }
      System.out.println("What flavor Choice drink?");
      System.out.println(
          "1) Coke\n2) Diet Coke\n3) Sprite\n4) Dr. Pepper\n5) Fanta Orange\n6) Root Beer\n7) Powerade\n8) Lemonade\n9) Hi-C Orange\n0) Water");
      int flavorChoice = scanner.nextInt();
      if (flavorChoice == 1) {
        flavor = Flavor.COKE;
        break;
      } else if (flavorChoice == 2) {
        flavor = Flavor.DIETCOKE;
        break;
      } else if (flavorChoice == 3) {
        flavor = Flavor.SPRITE;
        break;
        } else if (flavorChoice == 4) {
        flavor = Flavor.DRPEPPER;
        break;
      } else if (flavorChoice == 5) {
        flavor = Flavor.FANTAORANGE;
        break;
      } else if (flavorChoice == 6) {
        flavor = Flavor.ROOTBEER;
        break;
      } else if (flavorChoice == 7) {
        flavor = Flavor.POWERADE;
        break;
      } else if (flavorChoice == 8) {
        flavor = Flavor.LEMONADE;
        break;
      } else if (flavorChoice == 9) {
        flavor = Flavor.HICORANGE;
        break;
      } else if (flavorChoice == 0) {
        flavor = Flavor.WATER;
        break;
      } else {
        System.out.println("Invalid Input. Please try again.");
      }
    }
    drink = new Drink(size, flavor);
    drink.setFlavor(flavor);
    System.out.println("Drink: " + drink.getFlavor().toString().toLowerCase() + " $" + drink.getDrinkPrice());
    return drink;
  }
}
