import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderScreen {

  public static void newOrder(Scanner scanner) {
    boolean continueApp = true;
    //print current items in order
    while (continueApp) {
    try {
      System.out.println("Please select from the following options: ");
      System.out.println(
              "1) Add Sandwich\n2) Add Drink\n3) Add Chips\n4) Checkout\n0) Cancel - Back to Home");
      int userChoice = scanner.nextInt();
      switch (userChoice) {
        case 5: // this doesnt do anything as far as user input goes
          displayMenu();
          break;
        case 1:
          Sandwich sandwich = Sandwich.createSandwich(scanner);
          System.out.println("Sandwich added");

          //------ variable to save sandwich -----
          break;
        case 2:
          Drink.addDrink(scanner);
            System.out.println("Drink added");
          //do I need a variable to save drink?
          break;
        case 3:
          Chips.addChips();
            System.out.println("Chips added");
          //do I need a variable to save chips?
          break;
        case 4:
          // checkoutOrder();
          break;
        case 0:
          continueApp = false;
      }
    } catch (InputMismatchException e) {
      System.out.println("Invalid input. Please enter a number between 1 and 5.");
      scanner.nextLine();
    }
    // add everything to order, create order object to have all items, and run again
  }
    }

  public static void displayMenu() {
    // Define column widths for formatting
    int itemColWidth = 25; // Width for item names (e.g., "white", "steak")
    int priceColWidth = 10; // Width for prices (e.g., "5.50", "1.00")
    int categoryColWidth = 35; // Width for category headers (e.g., "Bread", "Meats")

    // --- Overall Menu Header ---
    System.out.println("=".repeat(itemColWidth + (priceColWidth * 3) + 6)); // Adjust for separators
    System.out.printf(
        "%-" + (itemColWidth + (priceColWidth * 3) + 6) + "s%n",
        "        SANDWICH ORDER MENU");
    System.out.println("=".repeat(itemColWidth + (priceColWidth * 3) + 6));

    // --- Price Header Row ---
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + "s | %"
            + priceColWidth
            + "s | %"
            + priceColWidth
            + "s%n",
        "Item",
        "4\"",
        "8\"",
        "12\"");
    System.out.println(
        "-".repeat(itemColWidth)
            + "+"
            + "-".repeat(priceColWidth + 2)
            + "+"
            + "-".repeat(priceColWidth + 2)
            + "+"
            + "-".repeat(priceColWidth + 2));

    // --- Bread Section ---
    System.out.printf("%n%-" + categoryColWidth + "s%n", "--- BREAD ---");
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f%n",
        "White",
        5.50,
        7.00,
        8.50);
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f%n",
        "Wheat",
        5.50,
        7.00,
        8.50);
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f%n",
        "Rye",
        5.50,
        7.00,
        8.50);
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f%n",
        "Wrap",
        5.50,
        7.00,
        8.50);

    // --- Meats Section ---
    System.out.printf("%n%-" + categoryColWidth + "s%n", "--- MEATS (Base Price) ---");
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f%n",
        "Steak",
        1.00,
        2.00,
        3.00);
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f%n",
        "Ham",
        1.00,
        2.00,
        3.00);
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f%n",
        "Salami",
        1.00,
        2.00,
        3.00);
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f%n",
        "Roast Beef",
        1.00,
        2.00,
        3.00);
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f%n",
        "Chicken",
        1.00,
        2.00,
        3.00);
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f%n",
        "Bacon",
        1.00,
        2.00,
        3.00);

    // --- Extra Meat Section ---
    System.out.printf("%n%-" + categoryColWidth + "s%n", "--- EXTRA MEAT ---");
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f%n",
        "Extra Meat",
        0.50,
        1.00,
        1.50);

    // --- Cheese Section ---
    System.out.printf("%n%-" + categoryColWidth + "s%n", "--- CHEESE (Base Price) ---");
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f%n",
        "American",
        0.75,
        1.50,
        2.25);
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f%n",
        "Provolone",
        0.75,
        1.50,
        2.25);
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f%n",
        "Cheddar",
        0.75,
        1.50,
        2.25);
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f%n",
        "Swiss",
        0.75,
        1.50,
        2.25);

    // --- Extra Cheese Section ---
    System.out.printf("%n%-" + categoryColWidth + "s%n", "--- EXTRA CHEESE ---");
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f | %"
            + priceColWidth
            + ".2f%n",
        "Extra Cheese",
        0.30,
        0.60,
        0.90);

    // --- Regular Toppings Section ---
    System.out.printf("%n%-" + categoryColWidth + "s%n", "--- REGULAR TOPPINGS (Included) ---");
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + "s | %"
            + priceColWidth
            + "s | %"
            + priceColWidth
            + "s%n",
        "Lettuce",
        "Included",
        "Included",
        "Included");
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + "s | %"
            + priceColWidth
            + "s | %"
            + priceColWidth
            + "s%n",
        "Peppers",
        "Included",
        "Included",
        "Included");
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + "s | %"
            + priceColWidth
            + "s | %"
            + priceColWidth
            + "s%n",
        "Onions",
        "Included",
        "Included",
        "Included");
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + "s | %"
            + priceColWidth
            + "s | %"
            + priceColWidth
            + "s%n",
        "Tomatoes",
        "Included",
        "Included",
        "Included");
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + "s | %"
            + priceColWidth
            + "s | %"
            + priceColWidth
            + "s%n",
        "Jalapeños",
        "Included",
        "Included",
        "Included");
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + "s | %"
            + priceColWidth
            + "s | %"
            + priceColWidth
            + "s%n",
        "Cucumbers",
        "Included",
        "Included",
        "Included");
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + "s | %"
            + priceColWidth
            + "s | %"
            + priceColWidth
            + "s%n",
        "Pickles",
        "Included",
        "Included",
        "Included");
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + "s | %"
            + priceColWidth
            + "s | %"
            + priceColWidth
            + "s%n",
        "Guacamole",
        "Included",
        "Included",
        "Included");
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + "s | %"
            + priceColWidth
            + "s | %"
            + priceColWidth
            + "s%n",
        "Mushrooms",
        "Included",
        "Included",
        "Included");

    // --- Sauces Section ---
    System.out.printf("%n%-" + categoryColWidth + "s%n", "--- SAUCES (Included) ---");
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + "s | %"
            + priceColWidth
            + "s | %"
            + priceColWidth
            + "s%n",
        "Mayo",
        "Included",
        "Included",
        "Included");
    System.out.printf(
        "%-"
            + itemColWidth
            + "s | %"
            + priceColWidth
            + "s | %"
            + priceColWidth
            + "s | %"
            + priceColWidth
            + "s%n",
        "Mustard",
        "Included",
        "Included",
        "Included");

    System.out.println("=".repeat(itemColWidth + (priceColWidth * 3) + 6));
  }

  public void getPrice() {}
}
