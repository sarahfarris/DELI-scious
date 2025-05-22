import java.util.ArrayList;

public class Sandwich extends OrderScreen {
    String bread;
    int size;
    ArrayList<String> toppings;
    boolean toasted;


    public Sandwich(String bread, int size, ArrayList<String> toppings, boolean toasted) {
        this.bread = bread;
        this.size = size;
        this.toppings = toppings;
        this.toasted = toasted;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "bread='" + bread + '\'' +
                ", size=" + size +
                ", toppings=" + toppings +
                ", toasted=" + toasted +
                '}';
    }

    public void addToppings() {
        toppings.add()
    }
}
