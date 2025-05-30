import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChipsTest {

    @Test
    public void testChipsPrice() {
        Chips chips = new Chips();
        assertEquals("Chips price should be 1.50", 1.50, chips.getPrice(), 0);
    }
}
