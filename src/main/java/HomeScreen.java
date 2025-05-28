import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeScreen {
  private static Scanner scanner = new Scanner(System.in);

  public static void welcomeScreen() {
    boolean continueApp = true;
    while (continueApp) {
      try {
        System.out.println("Welcome to DELI-scious! Please select from the following options:");
        System.out.println("1) New Order\n2) Exit");
        int userChoice = scanner.nextInt();
        if (userChoice == 1) {
          OrderScreen.newOrder(scanner);
          break;
        } else if (userChoice == 2) {
          System.out.println("Exiting application...");
          continueApp = false;
        }
      } catch (InputMismatchException e) {
        System.out.println(
            "Invalid input. Please select 1 for New order or 2 to exit the application.");
        scanner.nextLine();
      }
    }
  }
}
