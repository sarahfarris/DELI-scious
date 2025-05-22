import java.util.ArrayList;

public class OrderScreen {
  public void newOrder() {
    System.out.println("Please select from the following options: ");
    System.out.println(
        "1) Add Sandwich\n2) Add Drink\n3) Add Chips\n4) Checkout\n5) Cancel - Back to Home");
    int userChoice = HomeScreen.scanner.nextInt();
    if (userChoice == 1) {
      // orderSandwich();
    }
  }

  public void orderSandwich (String bread, int size, ArrayList<String> toppings, boolean toasted) {
    System.out.println("What type of bread would you like?");
    System.out.println("1) White\n2) Wheat\n3) Rye\n4) Wrap");
    bread = HomeScreen.scanner.nextLine();

    // do we need a string builder here to add this sandwich to a file? the sandwich will eventually
    // become an object
    System.out.println("What size would you like?");
    System.out.println("1) 4\"   $5.50\n" +
                    "2) 8\"   $7.00\n" +
                    "3) 12\"   $8.50");
    size = HomeScreen.scanner.nextInt();
    String strSize = Integer.toString(size);

    System.out.println("Please select from the following toppings:");
    System.out.println("");

    Sandwich sando = new Sandwich(bread, strSize, );
  }
}
