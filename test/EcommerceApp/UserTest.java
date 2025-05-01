package EcommerceApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest {
    private User user;

    private Item item;

    @BeforeEach
    public void setUp(){
        user = new User("firstName", "lastName", "email",
        "phoneNumber","password", "address");
    }

    @Test
    public void testThatUserCanSetFirstNameTest(){
        user.setFirstName("Danny");
        String name = user.getFirstName();
        assertEquals("Danny", name);
    }

    @Test
    public void testThatUserCanSetLastNameTest(){
        user.setLastName("Ade");
        String name = user.getLastName();
        assertEquals("Ade", name);
    }

    @Test
    public void testThatUserCanSetEmailTest(){
        user.setEmail("test@email.com");
        String email = user.getEmail();
        assertEquals("test@email.com", email);
    }

    @Test
    public void testThatUserCanSetPhoneNumberTest(){
        user.setPhoneNumber("081234567");
        String phoneNumber = user.getPhoneNumber();
        assertEquals("081234567", phoneNumber);
    }

    @Test
    public void testThatUserCanSetPasswordTest(){
        user.setPassword("12345");
        String passWord = user.getPassword();
        assertEquals("12345", passWord);
    }

    @Test
    public void testThatUserCanSetAddressTest(){
        user.setAddress("Ondo Street");
        String address = user.getAddress();
        assertEquals("Ondo Street", address);
    }

    @Test
    public void testThatUserCanHaveACartTest(){
        Cart cart = user.canHaveACart();
        assertNotNull(cart);
    }

    @Test
    public void testThatUserCanHaveACartToAddItemTest(){
        Cart cart = user.canHaveACart();
        item = new Item("Water", new BigDecimal("50.00"), 0);
        user.add(item);
        assertEquals(1, cart.count());
    }

    @Test
    public void testThatUserCanAddItemCartTwiceTest(){
        Cart cart = user.canHaveACart();
        assertEquals(0, cart.count());
        item = new Item("Water", new BigDecimal("50.00"), 0);
        user.add(item);
        assertEquals(1, cart.count());

        item = new Item("Bag", new BigDecimal("100.00"), 0);
        user.add(item);
        assertEquals(2, cart.count());
    }

    @Test
    public void testThatUserCanAddItemCartTwiceAndRemoveOneTest(){
        Cart cart = user.canHaveACart();
        item = new Item("Water", new BigDecimal("50.00"), 0);
        user.add(item);
        assertEquals(1, cart.count());

        item = new Item("Bag", new BigDecimal("100.00"), 0);
        String sItem = item.getItemName();
        user.add(item);
        assertEquals(2, cart.count());

        user.canRemoveItem(sItem);
        assertEquals(1, cart.count());
    }
}
