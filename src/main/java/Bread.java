import java.util.ArrayList;

public class Bread {

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



  @Override
  public String toString() {
    return "Bread{" +
            "breadType='" + breadType + '\'' +
            ", size='" + size + '\'' +
            ", price=" + price +
            '}';
  }
}
