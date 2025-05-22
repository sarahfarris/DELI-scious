import java.util.ArrayList;

public class Toppings<T> {
    ArrayList<T> toppings = new ArrayList<>();
    String type;
    String size;
    double price;

    public Toppings(String type, String size, double price) {
//        this.toppings = toppings;
        this.type = type;
        this.size = size;
        this.price = price;
    }

    public ArrayList<T> getToppings() {
        toppings.add((T) new Toppings("steak", "4\"", 1.00));
        toppings.add((T) new Toppings("steak", "8\"", 2.00));
        toppings.add((T) new Toppings ("steak", "12\"", 3.00));
        toppings.add((T) new Toppings ("steak +", "4\"", 1.50));
        toppings.add((T) new Toppings("steak +", "8\"", 3.00));
        toppings.add((T) new Toppings ("steak +", "12\"", 4.50));


        toppings.add((T) new Toppings("ham", "4\"", 1.00));
        toppings.add((T) new Toppings("ham", "8\"", 2.00));
        toppings.add((T) new Toppings ("ham", "12\"", 3.00));
        toppings.add((T) new Toppings ("ham +", "4\"", 1.50));
        toppings.add((T) new Toppings("ham +", "8\"", 3.00));
        toppings.add((T) new Toppings ("ham +", "12\"", 4.50));

        toppings.add((T) new Toppings("salami", "4\"", 1.00));
        toppings.add((T) new Toppings("salami", "8\"", 2.00));
        toppings.add((T) new Toppings ("salami", "12\"", 3.00));
        toppings.add((T) new Toppings ("salami +", "4\"", 1.50));
        toppings.add((T) new Toppings("salami +", "8\"", 3.00));
        toppings.add((T) new Toppings ("salami +", "12\"", 4.50));

        toppings.add((T) new Toppings("roast beef", "4\"", 1.00));
        toppings.add((T) new Toppings("roast beef", "8\"", 2.00));
        toppings.add((T) new Toppings ("roast beef", "12\"", 3.00));
        toppings.add((T) new Toppings ("roast beef +", "4\"", 1.50));
        toppings.add((T) new Toppings("roast beef +", "8\"", 3.00));
        toppings.add((T) new Toppings ("roast beef +", "12\"", 4.50));

        toppings.add((T) new Toppings("chicken", "4\"", 1.00));
        toppings.add((T) new Toppings("chicken", "8\"", 2.00));
        toppings.add((T) new Toppings ("chicken", "12\"", 3.00));
        toppings.add((T) new Toppings ("chicken +", "4\"", 1.50));
        toppings.add((T) new Toppings("chicken +", "8\"", 3.00));
        toppings.add((T) new Toppings ("chicken +", "12\"", 4.50));

        toppings.add((T) new Toppings("bacon", "4\"", 1.00));
        toppings.add((T) new Toppings("bacon", "8\"", 2.00));
        toppings.add((T) new Toppings ("bacon", "12\"", 3.00));
        toppings.add((T) new Toppings ("bacon +", "4\"", 1.50));
        toppings.add((T) new Toppings("bacon +", "8\"", 3.00));
        toppings.add((T) new Toppings ("bacon +", "12\"", 4.50));

        toppings.add((T) new Toppings("american", "4\"", 0.75));
        toppings.add((T) new Toppings("american", "8\"", 1.50));
        toppings.add((T) new Toppings ("american", "12\"", 2.25));
        toppings.add((T) new Toppings ("american +", "4\"", 1.05));
        toppings.add((T) new Toppings("american +", "8\"", 2.10));
        toppings.add((T) new Toppings ("american +", "12\"", 3.15));

        toppings.add((T) new Toppings("provolone", "4\"", 0.75));
        toppings.add((T) new Toppings("provolone", "8\"", 1.50));
        toppings.add((T) new Toppings ("provolone", "12\"", 2.25));
        toppings.add((T) new Toppings ("provolone +", "4\"", 1.05));
        toppings.add((T) new Toppings("provolone +", "8\"", 2.10));
        toppings.add((T) new Toppings ("provolone +", "12\"", 3.15));

        toppings.add((T) new Toppings("cheddar", "4\"", 0.75));
        toppings.add((T) new Toppings("cheddar", "8\"", 1.50));
        toppings.add((T) new Toppings ("cheddar", "12\"", 2.25));
        toppings.add((T) new Toppings ("cheddar +", "4\"", 1.05));
        toppings.add((T) new Toppings("cheddar +", "8\"", 2.10));
        toppings.add((T) new Toppings ("cheddar +", "12\"", 3.15));

        toppings.add((T) new Toppings("swiss", "4\"", 0.75));
        toppings.add((T) new Toppings("swiss", "8\"", 1.50));
        toppings.add((T) new Toppings ("swiss", "12\"", 2.25));
        toppings.add((T) new Toppings ("swiss +", "4\"", 1.05));
        toppings.add((T) new Toppings("swiss +", "8\"", 2.10));
        toppings.add((T) new Toppings ("swiss +", "12\"", 3.15));
        return toppings;
    }

    public void setToppings(ArrayList<T> toppings) {
        this.toppings = toppings;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public ArrayList<String> regularToppings() {
        ArrayList<String> regularToppings = new ArrayList<>();
        regularToppings.add("lettuce");
        regularToppings.add("peppers");
        regularToppings.add("onions");
        regularToppings.add("tomatoes");
        regularToppings.add("jalapenos");
        regularToppings.add("cucumbers");
        regularToppings.add("pickles");
        regularToppings.add("guacamole");
        regularToppings.add("mushrooms");
        return regularToppings;
    }

    public ArrayList<String> sauces() {
        ArrayList<String> sauces = new ArrayList<>();
        sauces.add("mayo");
        sauces.add("mustard");
        sauces.add("ketchup");
        sauces.add("ranch");
        sauces.add("thousand island");
        sauces.add("vinaigrette");
        return sauces;
    }
    public ArrayList<String> sides() {
        ArrayList<String> sides = new ArrayList<>();
        sides.add("au jus");
        sides.add("sauce");
        return sides;
    }
    public ArrayList<T> otherProducts() {
    //are we going to put the drinks and chips with their sizes and relative prices?
        return otherProducts();
    }
}

