import java.util.ArrayList;
import java.util.Scanner;

public class OrderScreen {

  public static void newOrder(Scanner scanner) {
    System.out.println("Please select from the following options: ");
    System.out.println(
        "1) Add Sandwich\n2) Add Drink\n3) Add Chips\n4) Checkout\n5) Cancel - Back to Home");
    int userChoice = scanner.nextInt();
    Sandwich sandwich;
    switch (userChoice) {
      case 1:
        sandwich = Sandwich.createSandwich(scanner);
       break;
      case 2:
      // addDrink();
        break;
      case 3:
      //addChips();
        break;
      case 4:
      //checkoutOrder();
        break;
      case 5:
      //homeScreen();
        break;
    }
  }


  public void getPrice(){}

  }




