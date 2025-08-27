package EcommerceApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EcommerceTest {
    private Ecommerce eShoppingMall;
     BigDecimal bigDecimal;

    @BeforeEach
    public void setUp() {
        eShoppingMall = new Ecommerce("EShoppingMall");
    }

    @Test
    public void testThatEcommerceAppCanRegisterUserTest(){
        eShoppingMall.registerUser("firstName", "lastName", "email",
                "phoneNumber","password", "address");
        assertEquals(1, eShoppingMall.getTotalNumberOfUser());
    }

    @Test
    public void testThatEcommerceAppCanFindARegisterUserTest(){
        eShoppingMall.registerUser("firstName", "lastName", "email",
                "phoneNumber","password", "address");
        assertEquals(1, eShoppingMall.getTotalNumberOfUser());

        User newUser = eShoppingMall.findARegisterUser("email");
        assertEquals("email", newUser.getEmail());
    }


    @Test
    public void testThatEcommerceAppCanCreateItemsTest(){
        eShoppingMall.registerUser("firstName", "lastName", "email",
                "phoneNumber","password", "address");
        assertEquals(1, eShoppingMall.getTotalNumberOfUser());

        eShoppingMall.createItems("name", new BigDecimal("0.00"), 0);
        assertEquals(1, eShoppingMall.getTotalNumberOfItems());
    }

    @Test
    public void testThatEcommerceAppCanSearchForItemsTest(){
        eShoppingMall.createItems("Rice", new BigDecimal("50.00"), 1);

        eShoppingMall.createItems("Bread", new BigDecimal("50.00"), 0);

        eShoppingMall.createItems("Water", new BigDecimal("100.00"), 2);

        assertEquals(3, eShoppingMall.getTotalNumberOfItems());

        String itemName = "Water";
        String word = eShoppingMall.searchForItem(itemName);
        assertEquals("Water $100.00 2", word);
    }

    @Test
    public void testThatEcommerceAppHaveACartTAndAddItemsTest(){
        eShoppingMall.registerUser("firstName", "lastName", "email",
                "phoneNumber","password", "address");
        assertEquals(1, eShoppingMall.getTotalNumberOfUser());

        Cart cart = eShoppingMall.createCart();
        assertNotNull(cart);

        eShoppingMall.addItemsToCart("name", bigDecimal = new BigDecimal("0.00"), 0);
        assertEquals(1, cart.count());
    }

    @Test
    public void testThatEcommerceAppHaveACartTAndAddItemsTwiceAndRemoveOnceTest(){
        eShoppingMall.registerUser("firstName", "lastName", "email",
                "phoneNumber","password", "address");
        assertEquals(1, eShoppingMall.getTotalNumberOfUser());

        Cart cart = eShoppingMall.createCart();
        assertEquals(0, cart.count());
        eShoppingMall.addItemsToCart("name", bigDecimal = new BigDecimal("0.00"), 0);
        assertEquals(1, cart.count());
        eShoppingMall.addItemsToCart("name", bigDecimal = new BigDecimal("0.00"), 0);
        assertEquals(2, cart.count());
        eShoppingMall.removeItem("name");
        assertEquals(1, cart.count());
    }
}
