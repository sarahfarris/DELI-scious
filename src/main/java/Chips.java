import java.util.Scanner;

public class Chips extends MenuItem{
    static Scanner scanner = new Scanner(System.in);
    public Chips(double price) {
        super(price);
    }

    public static Chips addChips() {
    System.out.println("Do you want to add chips to your order for $1.50?\nY - Yes\nN - No");
    String userChoice = scanner.nextLine();
    if (userChoice.equalsIgnoreCase("y")){
      System.out.println("How many chips would you like to add?");
    } else if (userChoice.equalsIgnoreCase("n")) {
    } else {
      System.out.println("Invalid input. Please try again.");
    }
        Chips chips = new Chips(1.50);
        return chips;
    }
}
