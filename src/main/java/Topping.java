import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Topping {
  String name;
  double price;
  ToppingType type;

  enum ToppingType {
    MEAT,
    CHEESE,
    SAUCE,
    SIDE,
    REGULAR
  }

  public static ArrayList<Topping> allPaidToppings;
  public static ArrayList<Topping> allFreeToppings;
  public static ArrayList<Topping> allToppings;
  static Scanner scanner = new Scanner(System.in);
  Sandwich.Size size;

  public Topping(String name, double price, ToppingType type) {
    this.price = price;
    this.name = name;
    this.type = type;
  }

  public double getPrice() {
    return price;
  }

  public String getName() {
    return name;
  }

  public static Topping getSpecificTopping(String name, Sandwich.Size size) {
    if (allFreeToppings == null || allFreeToppings.isEmpty()) {
      initializeFreeToppings();
    }
    if (allPaidToppings == null || allPaidToppings.isEmpty()) {
      initializePaidToppings(size);
    }
    if (allToppings == null || allToppings.isEmpty()) {
      allToppings = new ArrayList<>();
      allToppings.addAll(allPaidToppings);
      allToppings.addAll(allFreeToppings);
    }

    for (Topping t : allToppings) {
      if (t.getName().equalsIgnoreCase(name)) {
        return t;
      }
    }
    return null;
  }

  public static ArrayList<Topping> askUserForToppings(Sandwich.Size size) {
    ArrayList<Topping> allToppings = getPaidToppings(size);
    allToppings.addAll(getFreeToppings(size));
    return allToppings;
  }

  // prints free toppings through displayMenu format
  private static ArrayList<Topping> getFreeToppings(Sandwich.Size size) {
    if (allFreeToppings == null || allFreeToppings.isEmpty()) {
      initializeFreeToppings();
    }
    return getCustomerSelectedFreeToppings(size);
  }

  // add free toppings to sandwich
  public static ArrayList<Topping> getCustomerSelectedFreeToppings(Sandwich.Size size) {
    ArrayList<Topping> selectedFreeToppings = new ArrayList<>();
    System.out.println("Please select any free toppings to add:");
    printToppingsMenuForSize(allFreeToppings, size);
    while (true) {
      try {
        System.out.println(
            "Press m to see the menu again. Please select from the following free toppings by selecting the corresponding number:");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("m")) {
          printToppingsMenuForSize(allFreeToppings, size);
        } else {
          int menuChoice = Integer.parseInt(choice); // took out consume line
          try {
            if (menuChoice > 0) {
              Topping selectedTopping =
                  allFreeToppings.get(
                      menuChoice
                          - 1); // translates menu numbering (starting with 1) to java indexing
              // (starting with 0)
              System.out.println("You selected: " + selectedTopping.getName());
              selectedFreeToppings.add(selectedTopping);
            } else if (menuChoice == 0) {
              System.out.println("Finished selecting toppings");
              break;
            }
          } catch (Exception e) {
            System.out.println(
                "Invalid input. Please select a number between 0 and "
                    + allFreeToppings.size()
                    + ".");
          }
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid input.");
      }
    }
    return selectedFreeToppings;
  }

  // arraylist that will be split based on sandwich size
  public static void initializeFreeToppings() {
    allFreeToppings = new ArrayList<>(); // list initialization
    allFreeToppings.add(new Topping("Lettuce", 0, ToppingType.REGULAR));
    allFreeToppings.add(new Topping("Peppers", 0, ToppingType.REGULAR));
    allFreeToppings.add(new Topping("Onions", 0, ToppingType.REGULAR));
    allFreeToppings.add(new Topping("Tomatoes", 0, ToppingType.REGULAR));
    allFreeToppings.add(new Topping("Jalapenos", 0, ToppingType.REGULAR));
    allFreeToppings.add(new Topping("Cucumbers", 0, ToppingType.REGULAR));
    allFreeToppings.add(new Topping("Pickles", 0, ToppingType.REGULAR));
    allFreeToppings.add(new Topping("Guacamole", 0, ToppingType.REGULAR));
    allFreeToppings.add(new Topping("Mushrooms", 0, ToppingType.REGULAR));

    allFreeToppings.add(new Topping("Mayo", 0, ToppingType.SAUCE));
    allFreeToppings.add(new Topping("Mustard", 0, ToppingType.SAUCE));
    allFreeToppings.add(new Topping("Ketchup", 0, ToppingType.SAUCE));
    allFreeToppings.add(new Topping("Ranch", 0, ToppingType.SAUCE));
    allFreeToppings.add(new Topping("Thousand Island", 0, ToppingType.SAUCE));
    allFreeToppings.add(new Topping("Vinaigrette", 0, ToppingType.SAUCE));

    allFreeToppings.add(new Topping("Au jus", 0, ToppingType.SIDE));
    allFreeToppings.add(new Topping("Sauce", 0, ToppingType.SIDE)); // sauce on side? special sauce?
  }

  private static ArrayList<Topping> getPaidToppings(Sandwich.Size size) {
    if (allPaidToppings == null || allPaidToppings.isEmpty()) {
      initializePaidToppings(size);
    }
    return getCustomerSelectedToppings(size);
  }

  //  list according to selected sandwich size
  public static void initializePaidToppings(Sandwich.Size size) {
    allPaidToppings = new ArrayList<>(); // list initialization
    if (size == Sandwich.Size.SMALL) {
      // meat
      allPaidToppings.add(new Topping("Steak", 1.00, ToppingType.MEAT));
      allPaidToppings.add(new Topping("Ham", 1.00, ToppingType.MEAT));
      allPaidToppings.add(new Topping("Salami", 1.00, ToppingType.MEAT));
      allPaidToppings.add(new Topping("Roast Beef", 1.00, ToppingType.MEAT));
      allPaidToppings.add(new Topping("Chicken", 1.00, ToppingType.MEAT));
      allPaidToppings.add(new Topping("Bacon", 1.00, ToppingType.MEAT));
      allPaidToppings.add(
          new Topping("Extra Meat", 0.50, ToppingType.MEAT)); // extra charge, not total price

      // cheese
      allPaidToppings.add(new Topping("American", 0.75, ToppingType.CHEESE));
      allPaidToppings.add(new Topping("Provolone", 0.75, ToppingType.CHEESE));
      allPaidToppings.add(new Topping("Cheddar", 0.75, ToppingType.CHEESE));
      allPaidToppings.add(new Topping("Swiss", 0.75, ToppingType.CHEESE));
      allPaidToppings.add(new Topping("Extra Cheese", 0.30, ToppingType.CHEESE)); // extra charge

    } else if (size == Sandwich.Size.MEDIUM) {
      // meat
      allPaidToppings.add(new Topping("Steak", 2.00, ToppingType.MEAT));
      allPaidToppings.add(new Topping("Ham", 2.00, ToppingType.MEAT));
      allPaidToppings.add(new Topping("Salami", 2.00, ToppingType.MEAT));
      allPaidToppings.add(new Topping("Roast Beef", 2.00, ToppingType.MEAT));
      allPaidToppings.add(new Topping("Chicken", 2.00, ToppingType.MEAT));
      allPaidToppings.add(new Topping("Bacon", 2.00, ToppingType.MEAT));
      allPaidToppings.add(
          new Topping("Extra Meat", 1.00, ToppingType.MEAT)); // extra charge, not total price

      // cheese
      allPaidToppings.add(new Topping("American", 1.50, ToppingType.CHEESE));
      allPaidToppings.add(new Topping("Provolone", 1.50, ToppingType.CHEESE));
      allPaidToppings.add(new Topping("Cheddar", 1.50, ToppingType.CHEESE));
      allPaidToppings.add(new Topping("Swiss", 1.50, ToppingType.CHEESE));
      allPaidToppings.add(new Topping("Extra Cheese", 0.60, ToppingType.CHEESE));

    } else if (size == Sandwich.Size.LARGE) {
      // meat
      allPaidToppings.add(new Topping("Steak", 3.00, ToppingType.MEAT));
      allPaidToppings.add(new Topping("Ham", 3.00, ToppingType.MEAT));
      allPaidToppings.add(new Topping("Salami", 3.00, ToppingType.MEAT));
      allPaidToppings.add(new Topping("Roast Beef", 3.00, ToppingType.MEAT));
      allPaidToppings.add(new Topping("Chicken", 3.00, ToppingType.MEAT));
      allPaidToppings.add(new Topping("Bacon", 3.00, ToppingType.MEAT));
      allPaidToppings.add(
          new Topping("Extra Meat", 1.50, ToppingType.MEAT)); // extra charge, not total price

      // cheese
      allPaidToppings.add(new Topping("American", 2.25, ToppingType.CHEESE));
      allPaidToppings.add(new Topping("Provolone", 2.25, ToppingType.CHEESE));
      allPaidToppings.add(new Topping("Cheddar", 2.25, ToppingType.CHEESE));
      allPaidToppings.add(new Topping("Swiss", 2.25, ToppingType.CHEESE));
      allPaidToppings.add(new Topping("Extra Cheese", 0.90, ToppingType.CHEESE));
    }
  }

  // displays paid toppings and allows user to select toppings, toppings printed based on sandwich
  // size
  public static ArrayList<Topping> getCustomerSelectedToppings(Sandwich.Size size) {
    printToppingsMenuForSize(allPaidToppings, size);
    ArrayList<Topping> selectedToppings = new ArrayList<>();
    boolean addingToppings = true;
    while (addingToppings) {
      System.out.println(
          "Press m to see the menu again. Please select from the following paid toppings by selecting the corresponding number:");
      String choice = scanner.nextLine();
      if (choice.equalsIgnoreCase("m")) {
        printToppingsMenuForSize(allPaidToppings, size);
      } else {
        try {
          int menuChoice = Integer.parseInt(choice);
          if (menuChoice > 0) {
            Topping selectedTopping =
                allPaidToppings.get(
                    menuChoice - 1); // translates menu numbering (starting with 1) to java indexing
            selectedToppings.add(selectedTopping);
          } else if (menuChoice == 0) {
            System.out.println("Finished selecting paid toppings");
            addingToppings = false;
          }
        } catch (Exception e) {
          System.out.println(
              "Invalid input. Please select a number between 0 and "
                  + allPaidToppings.size()
                  + " or input m to see the menu again.");
        }
      }
    }
    return selectedToppings;
  }

  public static void removeToppingsFromSandwich(
      Sandwich.Size sandwichSize, ArrayList<Topping> selectedToppings) {
    boolean removingToppings = true;
    while (removingToppings) {
      // prints the selected toppings by index with same formula as menu
      printToppingsMenuForSize(selectedToppings, sandwichSize);
      // ask user which toppings they would like to remove by index
      System.out.println(
          "Select the toppings you would like to remove by pressing the corresponding number: ");
      try {
        int removeChoice = scanner.nextInt();
        if (removeChoice > 0) {
          Topping selectedTopping =
              selectedToppings.remove(
                  removeChoice
                      - 1); // translates menu numbering (starting with 1) to java indexing
                            // (starting with 0)
          selectedToppings.remove(selectedTopping);
        } else if (removeChoice == 0) {
          System.out.println("Finished removing toppings.");
          removingToppings = false;
        } else {
          System.out.println("Number not valid. Please try again.");
        }
      } catch (InputMismatchException e) {
        System.out.println("Invalid input.");
        scanner.nextLine(); // necessary to prevent infinite looping
      }
    }
  }

  @Override
  public String toString() {
    return name + " ($" + String.format("%.2f", price) + ")";
  }

  public static void printToppingsMenuForSize(
      ArrayList<Topping> toppingsList, Sandwich.Size sandwichSize) {
    int indexColWidth = 5; // Width for the index column (e.g., "1.")
    int itemColWidth = 20; // Width for the topping name column
    int priceColWidth = 12; // Width for the price column
    int totalWidth = indexColWidth + itemColWidth + priceColWidth + 6; // Adjust for separators

    // --- Header for the specific size ---
    System.out.println("\n" + "=".repeat(totalWidth));
    System.out.printf(
        "%-" + totalWidth + "s%n", "   AVAILABLE TOPPINGS (" + sandwichSize.getInches() + "\")");
    System.out.println("=".repeat(totalWidth));

    // --- Table Header ---
    System.out.printf(
        "%-" + indexColWidth + "s | %-" + itemColWidth + "s | %" + priceColWidth + "s%n",
        "No.",
        "Topping",
        "Price");
    System.out.println(
        "-".repeat(indexColWidth)
            + "+"
            + "-".repeat(itemColWidth + 2)
            + "+"
            + "-".repeat(priceColWidth + 2));

    // --- Print each topping with an index ---
    for (int i = 0; i < toppingsList.size(); i++) {
      Topping topping = toppingsList.get(i);
      System.out.printf(
          "%-" + indexColWidth + "d | %-" + itemColWidth + "s | %" + priceColWidth + ".2f%n",
          (i + 1),
          topping.getName(),
          topping.getPrice()); // (i + 1) for 1-based indexing
    }

    // --- Finish selection option ---
    System.out.println(
        "-".repeat(indexColWidth)
            + "+"
            + "-".repeat(itemColWidth + 2)
            + "+"
            + "-".repeat(priceColWidth + 2));
    System.out.printf(
        "%-" + indexColWidth + "d | %-" + itemColWidth + "s | %" + priceColWidth + "s%n",
        0,
        "Finish selection",
        ""); // Price column empty for "Finish"
    System.out.println("=".repeat(totalWidth));
  }
}
