package EcommerceApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ItemTest {
    private Item item;

    private Cart cart;

    BigDecimal bigDecimal;

    @BeforeEach
    public void setUp(){
        item = new Item("name",bigDecimal = new BigDecimal("0.00"), 0);
    }

    @Test
    public void testThatItemsValueCanBeCollectedFirstAndBeStoredTest(){
        item.setItemName("Water");
        String firstItem = item.getItemName();
        assertEquals("Water", firstItem);


        item.setPrice(new BigDecimal("100.00"));
        String amount = String.valueOf(item.getPrice());
        assertEquals("$100.00", amount);

        item.setQuantity(1);
        int nums = item.getQuantity();
        assertEquals(1, nums);

        cart = new Cart();
        assertNotNull(cart);

        cart.add(item);
        assertEquals(1, cart.count());
    }

    @Test
    public void testThatItemsValueCanBeCollectedTwiceAndBeStoredTest(){
        item.setItemName("Water");
        String firstItem = item.getItemName();
        assertEquals("Water", firstItem);

        item.setPrice(new BigDecimal("100.00"));
        String amount = String.valueOf(item.getPrice());
        assertEquals("$100.00", amount);

        item.setQuantity(1);
        int nums = item.getQuantity();
        assertEquals(1, nums);

        cart = new Cart();
        assertNotNull(cart);

        cart.add(item);
        assertEquals(1, cart.count());

        item.setItemName("Bag");
        String sItem = item.getItemName();
        assertEquals("Bag", sItem);

        item.setPrice(new BigDecimal("100.00"));
        String amountN = String.valueOf(item.getPrice());
        assertEquals("$100.00", amountN);

        item.setQuantity(1);
        int numsQ = item.getQuantity();
        assertEquals(1, numsQ);


        cart.add(item);
        assertEquals(2, cart.count());
    }

    @Test
    public void testThatItemsValueCanBeRemovedTest(){
        item.setItemName("Water");
        String firstItem = item.getItemName();
        assertEquals("Water", firstItem);

        item.setPrice(new BigDecimal("100.00"));
        String amount = String.valueOf(item.getPrice());
        assertEquals("$100.00", amount);

        item.setQuantity(1);
        int nums = item.getQuantity();
        assertEquals(1, nums);

        cart = new Cart();
        assertNotNull(cart);

        cart.add(item);
        assertEquals(1, cart.count());


        item.setItemName("Bag");
        String sItem = item.getItemName();
        assertEquals("Bag", sItem);

        item.setPrice(new BigDecimal("100.00"));
        String amountN = String.valueOf(item.getPrice());
        assertEquals("$100.00", amountN);

        item.setQuantity(1);
        int numsQ = item.getQuantity();
        assertEquals(1, numsQ);

        cart.add(item);
        assertEquals(2, cart.count());

        cart.Remove(sItem);
        assertEquals(1, cart.count());
    }
}
