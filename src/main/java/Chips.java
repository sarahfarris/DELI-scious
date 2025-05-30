import java.util.InputMismatchException;
import java.util.Scanner;

public class Chips extends MenuItem {

  public Chips() {
    super.setPrice(1.50);
    setItemDescription();
  }

  public double getPrice() {
    return super.getPrice();
  }

  public static Chips addChips(Scanner scanner) {
    System.out.println("Do you want to add chips to your order for $1.50?\nY - Yes\nN - No");
    try {
      scanner.nextLine();
      String userChoice = scanner.nextLine();
      if (userChoice.equalsIgnoreCase("y")) {
        return new Chips();
      } else if (userChoice.equalsIgnoreCase("n")) {
        return null;
      } else {
        System.out.println("Invalid input. Returning to main menu.");
        return null;
      }
    } catch (InputMismatchException e) {
      System.out.println("Invalid input. Returning to main menu");
      return null;
    }
  }

  @Override
  public String toString() {
    return "chips" + " - $" + String.format("%.2f", getPrice());
  }

  public void setItemDescription() {
    // Format for receipt: Name Price
    itemDescription = String.format("%-25s $%.2f%n","chips", getPrice());
  }
}
