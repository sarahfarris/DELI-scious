import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Chips extends MenuItem {
  static Scanner scanner = new Scanner(System.in);

  public Chips(double price) {
    super(price);
  }

  // changed return type to an array list of chips to add to order
  public static ArrayList<Chips> addChips() {
    ArrayList<Chips> chips = new ArrayList<>();
    int nrOfChips; // user will input how many chips they want
    boolean addingChips = true;
    while (addingChips) {
      System.out.println("Do you want to add chips to your order for $1.50?\nY - Yes\nN - No");
      try {
        String userChoice = scanner.nextLine();
        if (userChoice.equalsIgnoreCase("y")) {
          System.out.println("How many chips would you like to add?");
          try {
            nrOfChips = scanner.nextInt();
            //adds nrOfChips to array list, creates the objects of chips correlating to the number
            for (int i = 0; i < nrOfChips; i++) {
              chips.add(new Chips(1.50));
            }
            System.out.println(nrOfChips + " chips added");
            addingChips = false;
          } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number of how many chips you would like to add:");
          }
        } else if (userChoice.equalsIgnoreCase("n")) {
          addingChips = false;
        } else {
          System.out.println("Invalid input. Please select Y for yes or N for no.");
        }
      } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please try again.");
      }
    }
    return chips;
  }
}
