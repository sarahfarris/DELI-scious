import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BreadTest {

    @Test
    public void testBreadCreationAndPriceForMediumWhite() {
        Bread mediumWhiteBread = new Bread(Sandwich.Size.MEDIUM, "White");

        assertEquals("Bread type should be 'White'", "White", mediumWhiteBread.getBreadType());
        assertEquals("Medium bread is $7", 7.0, mediumWhiteBread.price, 0);
    }

//    @Test
//    void testBreadCreationAndPriceForSmallRye() {
//        // Test 2: Verify correct price for a small-sized rye bread
//        Bread smallRyeBread = new Bread(Sandwich.Size.SMALL, "Rye");
//        assertEquals("Rye", smallRyeBread.getBreadType(), "Bread type should be 'Rye'");
//        assertEquals(5.50, smallRyeBread.getPrice(), 0.001, "Price for Small bread should be 5.50");
//    }
//
//    @Test
//    void testBreadCreationAndPriceForLargeWrap() {
//        // Test 3: Verify correct price for a large-sized wrap
//        Bread largeWrap = new Bread(Sandwich.Size.LARGE, "Wrap");
//        assertEquals("Wrap", largeWrap.getBreadType(), "Bread type should be 'Wrap'");
//        assertEquals(8.50, largeWrap.getPrice(), 0.001, "Price for Large bread should be 8.50");
//    }
}