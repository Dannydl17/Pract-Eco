package EcommerceApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

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
        User user = eShoppingMall.canRegisterUser("firstName", "lastName", "email",
                "phoneNumber","password", "address");
        assertEquals(1, eShoppingMall.getTotalNumberOfUser());
        assertNotNull(user);
    }

    @Test
    public void testThatEcommerceAppCanFindARegisterUserTest(){
        User user = eShoppingMall.canRegisterUser("firstName", "lastName", "email",
                "phoneNumber","password", "address");
        assertEquals(1, eShoppingMall.getTotalNumberOfUser());
        assertNotNull(user);
        User newUser = eShoppingMall.canFindARegisterUser("email");
        assertEquals("email", newUser.getEmail());
    }


    @Test
    public void testThatEcommerceAppCanGiveACartTToARegisterUserTest(){
        User user = eShoppingMall.canRegisterUser("firstName", "lastName", "email",
                "phoneNumber","password", "address");
        assertEquals(1, eShoppingMall.getTotalNumberOfUser());
        assertNotNull(user);
        User newUser = eShoppingMall.canFindARegisterUser("email");
        assertEquals("email", newUser.getEmail());
        Cart cart = eShoppingMall.canCreateCartForUser();
        assertNotNull(cart);
    }

    @Test
    public void testThatEcommerceAppCanGiveACartTToARegisterUserAndARegisterUserCanAddItemsTest(){
        User user = eShoppingMall.canRegisterUser("firstName", "lastName", "email",
                "phoneNumber","password", "address");
        assertEquals(1, eShoppingMall.getTotalNumberOfUser());
        assertNotNull(user);
        User newUser = eShoppingMall.canFindARegisterUser("email");
        assertEquals("email", newUser.getEmail());
        Cart cart = eShoppingMall.canCreateCartForUser();
        assertEquals(0, cart.count());
        eShoppingMall.canAddItemsToCart("name", bigDecimal = new BigDecimal("0.00"), 0);
        assertEquals(1, cart.count());
    }

    @Test
    public void testThatEcommerceAppCanGiveACartTToARegisterUserAndARegisterUserCanAddItemsTwiceAndRemoveOnceTest(){
        User user = eShoppingMall.canRegisterUser("firstName", "lastName", "email",
                "phoneNumber","password", "address");
        assertEquals(1, eShoppingMall.getTotalNumberOfUser());
        assertNotNull(user);
        User newUser = eShoppingMall.canFindARegisterUser("email");
        assertEquals("email", newUser.getEmail());
        Cart cart = eShoppingMall.canCreateCartForUser();
        assertEquals(0, cart.count());
        eShoppingMall.canAddItemsToCart("name", bigDecimal = new BigDecimal("0.00"), 0);
        assertEquals(1, cart.count());
        eShoppingMall.canAddItemsToCart("name", bigDecimal = new BigDecimal("0.00"), 0);
        assertEquals(2, cart.count());
        eShoppingMall.canRemoveItem("name");
        assertEquals(1, cart.count());
    }
}
