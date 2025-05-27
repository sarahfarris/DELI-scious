import java.util.Scanner;

public class Bread {
  static Scanner scanner = new Scanner(System.in);
  String breadType;
  double price;

  public Bread(Sandwich.Size size) {
    switch (size) {
        case SMALL -> price = 5.50;
        case MEDIUM -> price = 7;
        case LARGE -> price = 8.50;
    }
  }

  public String getBreadType() {
    return breadType;
  }

  public void setBreadType(String breadType) {
    this.breadType = breadType;
  }

  // not sure if we need these yet as these @override methods are part of implementing Topping
  public String getType() {
    return "";
  }
  public void setType(String type) {}

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  // Here we are creating bread for the user
  public static Bread createBread(Scanner scanner, Sandwich.Size size) {
    Bread bread = new Bread(size);
    while (true) {
      System.out.println("What name of bread would you like?");
      System.out.println("1) White\n2) Wheat\n3) Rye\n4) Wrap");
      int userChoice = scanner.nextInt();
      scanner.nextLine(); // consume line
      if (userChoice == 1) {
        bread.setBreadType("white");
        break;
      } else if (userChoice == 2) {
        bread.setBreadType("wheat");
        break;
      } else if (userChoice == 3) {
        bread.setBreadType("rye");
        break;
      } else if (userChoice == 4) {
        bread.setBreadType("wrap");
        break;
      } else {
        System.out.println("Invalid input. Please try again");
      }
    }
    return bread;
  }

  //took out size as I'm not sure how to incorporate that as Enum
  @Override
  public String toString() {
    return "Bread{" +
            "breadType='" + breadType + '\'' +
            ", price=" + price +
            '}';
  }
}
