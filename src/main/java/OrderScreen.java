import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderScreen {
  public static void newOrder(Scanner scanner) {
    ArrayList<MenuItem> cart = new ArrayList<>();
    double total = 0.0;
    boolean continueApp = true;
    // print current items in order, show "basket' with newest entries first
    while (continueApp) {
      try {
        if (total > 0) {
          System.out.println("----------------------------------");
          System.out.println("Total: $" + total);
          System.out.println("----------------------------------");
        }
        System.out.println("Please select from the following options: ");
        // press 5 to see what's in the cart
        System.out.println(
            "1) Add Sandwich\n2) Add Drink\n3) Add Chips\n4) Checkout\n5) View Cart\n0) Cancel - Back to Home");
        int userChoice = scanner.nextInt();
        switch (userChoice) {
          case 0:
            continueApp = false;
            System.out.println("Exiting. Have a good day!");
            break;
          case 1:
            Sandwich sandwich = Sandwich.addSandwich(scanner);
            cart.addFirst(sandwich); // saves sandwich variable in the cart
            total += sandwich.getPrice();
            System.out.println("Sandwich added");
            break;
          case 2:
            Drink drink = Drink.addDrink(scanner);
            cart.addFirst(drink);
            total += drink.getPrice();
            System.out.println("Drink added");
            break;
          case 3:
            Chips chips = Chips.addChips(scanner);
            if (chips == null) {
              break;
            }
            cart.addFirst(chips); // need to make sure this adds however many chips the user adds
            total += chips.getPrice();
            System.out.println("Chips added");
            break;
          case 4:
            // checkoutOrder();
            break;
          case 5:
            System.out.println("----------------------------------");
            System.out.println("---------------CART---------------");
            for (MenuItem m : cart) {
              System.out.println("----------------------------------");
              System.out.println(m);
            }
            System.out.println("----------------------------------");
            break;
        }
      } catch (InputMismatchException e) {
        System.out.println(
            "Invalid input. Please enter a number between 1 and 5, or 0 to go back to Home.");
        scanner.nextLine();
      }
      // add everything to order, create order object to have all items, and run again
    }
  }
}
