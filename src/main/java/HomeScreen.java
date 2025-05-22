import java.util.Scanner;

public class HomeScreen {
    static Scanner scanner = new Scanner(System.in);

    public void welcomeScreen(){
    System.out.println("Welcome to DELI-scious! Please select from the following options:");
    System.out.println("1) New Order\n2) Exit");

        int userChoice = scanner.nextInt();
        if (userChoice == 1) {
            //order screen
        }
    }
}
