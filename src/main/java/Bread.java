import java.util.Scanner;
// not sure if I want to have the implement topping with @Override methods
public class Bread implements Topping {
  static Scanner scanner = new Scanner(System.in);
  String breadType;
  String size;
  double price;


  public Bread(String breadType, String size, double price) {
    this.breadType = breadType;
    this.size = size;
    this.price = price;

  }

  public String getBreadType() {
    return breadType;
  }

  public void setBreadType(String breadType) {
    this.breadType = breadType;
  }

  //not sure if we need these yet as these @override methods are part of implementing Topping
  @Override
  public String getType() {
    return "";
  }

  @Override
  public void setType(String type) {

  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }


  public static void selectSize(Scanner scanner) {
    System.out.println("What size would you like?");
    System.out.println("1) 4\"   $5.50\n2) 8\"   $7.00\n3) 12\"   $8.50");
    int userChoice = scanner.nextInt();
    scanner.nextLine(); // consume line
    double size = userChoice;
    if (userChoice == 1) {
      size = 4.0;
    } else if (userChoice == 2) {
      size = 8.0;
    } else if (userChoice == 3){
      size = 12.0;
    } else {
      System.out.println("Invalid input. Please try again");
      selectSize(scanner);
      //fix the stack trace error that could happen
    }
  }
  public static void selectBread(Scanner scanner) {
    System.out.println("What type of bread would you like?");
    System.out.println("1) White\n2) Wheat\n3) Rye\n4) Wrap");
//    scanner.nextLine(); // consume line

    int userChoice = scanner.nextInt();
    String breadType = scanner.nextLine();
    if (userChoice == 1) {
      breadType = "White";
    } else if (userChoice == 2) {
      breadType = "Wheat";
    } else if (userChoice == 3){
      breadType = "Rye";
    } else if (userChoice == 4) {
      breadType = "Wrap";
    } else {
      System.out.println("Invalid input. Please try again");
      selectBread(scanner);
      //fix the stack trace error that could happen
    }
    // do we need a string builder here to add this sandwich to a file? the sandwich will eventually
    // become an object

  }


  @Override
  public String toString() {
    return "Bread{" +
            "breadType='" + breadType + '\'' +
            ", size='" + size + '\'' +
            ", price=" + price +
            '}';
  }
}
