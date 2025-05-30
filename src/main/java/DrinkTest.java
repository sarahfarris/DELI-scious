import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DrinkTest {

  @Test
  public void testDrinkConstructorAndPriceForMediumCoke() {
    Drink drink = new Drink(Drink.Size.MEDIUM, Drink.Flavor.COKE);
    assertEquals("Drink size should be MEDIUM", Drink.Size.MEDIUM, drink.size);
    assertEquals("Drink flavor should be COKE", Drink.Flavor.COKE, drink.getFlavor());
    assertEquals("Price for Medium Coke should be 2.50", 2.50, drink.getDrinkPrice(), 0);
  }

  @Test
  public void testDrinkConstructorAndPriceForPowerade() {
    Drink powerade = new Drink(Drink.Size.SMALL, Drink.Flavor.POWERADE);
    assertEquals("Drink size should be SMALL", Drink.Size.SMALL, powerade.size);
    assertEquals("Drink flavor should be POWERADE", Drink.Flavor.POWERADE, powerade.getFlavor());
    assertEquals("Price for Small Powerade should be 2.00", 2.00, powerade.getDrinkPrice(), 0);
  }

  @Test
  public void testAddDrinkWithValidInput() {
    // Test 3: Simulate valid user input for size and flavor
    String simulatedInput = "1\n3\n"; // Size: Small (1), Flavor: Sprite (3)
    System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
    Scanner testScanner = new Scanner(System.in);

    Drink drink = Drink.addDrink(testScanner);

    assertNotNull("addDrink should return a Drink object for valid input", drink);
    assertEquals("Drink size should be SMALL", Drink.Size.SMALL, drink.size);
    assertEquals("Drink flavor should be SPRITE", Drink.Flavor.SPRITE, drink.getFlavor());
    assertEquals("Price for Small Sprite should be 2.00", 2.00, drink.getDrinkPrice(), 0.001);
  }
}
