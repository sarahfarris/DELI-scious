import java.util.Scanner;

public class HomeScreen {
  private static Scanner scanner = new Scanner(System.in);

  public static void welcomeScreen() {
    System.out.println("Welcome to DELI-scious! Please select from the following options:");
    System.out.println("1) New Order\n2) Exit");
    boolean continueApp = true;
    while (continueApp) {
      int userChoice = scanner.nextInt();
      if (userChoice == 1) {
        OrderScreen.newOrder(scanner);
        break;
      } else {
        System.out.println("Exiting application...");
        continueApp = false;
      }
    }
  }
}
