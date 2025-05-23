import java.util.ArrayList;
import java.util.Scanner;

public class Sandwich {

    String bread;
    String size;
    ArrayList<Topping> toppings;
    boolean toasted;
    double basePrice;

    public Sandwich(String bread, String size, boolean toasted, double basePrice) {

        this.bread = bread;
        this.size = size;
        this.toasted = toasted;
        this.basePrice = basePrice;

        this.toppings = new ArrayList<>();
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public void addTopping(){

    }

    public static Sandwich createSandwich(Scanner scanner){
        selectSize(scanner);
    }

    public static double selectSize(Scanner scanner) {
        System.out.println("What size would you like?");
        System.out.println("1) 4\"   $5.50\n2) 8\"   $7.00\n3) 12\"   $8.50");
        int userChoice = scanner.nextInt();
        double size = scanner.nextDouble();
        if (userChoice == 1) {
            return 4.0;
        } else if (userChoice == 2) {
            return 8.0;
        } else if (userChoice == 3){
            return 12.0;
        }

        return size;
    }
    public static void selectBread() {
        System.out.println("What type of bread would you like?");
        System.out.println("1) White\n2) Wheat\n3) Rye\n4) Wrap");
        String bread = HomeScreen.scanner.nextLine();
        HomeScreen.scanner.nextLine(); // consume line

        // do we need a string builder here to add this sandwich to a file? the sandwich will eventually
        // become an object

    }


    public void addRegularTopping(){}
    public void addDrink(){}
    public void addSauces(){}
    public void addSides(){}

    @Override
    public String toString() {
        return "Sandwich{" +
                "bread='" + bread + '\'' +
                ", size=" + size +
                ", toppings=" + toppings +
                ", toasted=" + toasted +
                '}';
    }

}
