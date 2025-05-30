import java.util.InputMismatchException;
import java.util.Scanner;

public class Bread {
  static Scanner scanner = new Scanner(System.in);
  String breadType;
  double price;

  public Bread(Sandwich.Size size, String type) {
    switch (size) {
      case SMALL -> price = 5.50;
      case MEDIUM -> price = 7;
      case LARGE -> price = 8.50;
    }
    this.breadType = type;
  }

  public String getBreadType() {
    return breadType;
  }


  public double getPrice() {
    return price;
  }

  // Here we are creating bread for the user
  // Will the type of bread be saved to the receipt if its not its own ENUM like we did with
  // everything else?
  public static Bread createBread(Scanner scanner, Sandwich.Size size) {
    String type;
    while (true) {
      try {
        System.out.println("What type of bread would you like?");
        System.out.println("1) White\n2) Wheat\n3) Rye\n4) Wrap");
        int userChoice = scanner.nextInt();
        scanner.nextLine(); // consume line
        if (userChoice == 1) {
          type = "white";
          break;
        } else if (userChoice == 2) {
          type = "wheat";
          break;
        } else if (userChoice == 3) {
          type = "rye";
          break;
        } else if (userChoice == 4) {
          type = "wrap";
          break;
        }
      } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please try again.");
        scanner.nextLine(); // keeps loop on track
      }
    }
    return new Bread(size, type);
  }
}
