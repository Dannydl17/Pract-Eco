package EcommerceApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

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
        eShoppingMall.canRegisterUser("firstName", "lastName", "email",
                "phoneNumber","password", "address");
        assertEquals(1, eShoppingMall.getTotalNumberOfUser());
    }

    @Test
    public void testThatEcommerceAppCanFindARegisterUserTest(){
        eShoppingMall.canRegisterUser("firstName", "lastName", "email",
                "phoneNumber","password", "address");
        assertEquals(1, eShoppingMall.getTotalNumberOfUser());

        User newUser = eShoppingMall.canFindARegisterUser("email");
        assertEquals("email", newUser.getEmail());
    }


    @Test
    public void testThatEcommerceAppCanGiveACartTToARegisterUserTest(){
        eShoppingMall.canRegisterUser("firstName", "lastName", "email",
                "phoneNumber","password", "address");
        assertEquals(1, eShoppingMall.getTotalNumberOfUser());

        User newUser = eShoppingMall.canFindARegisterUser("email");
        assertEquals("email", newUser.getEmail());
        Cart cart = eShoppingMall.canCreateCartForUser();
        assertNotNull(cart);
    }

    @Test
    public void testThatEcommerceAppCanGiveACartTToARegisterUserAndARegisterUserCanAddItemsTest(){
        eShoppingMall.canRegisterUser("firstName", "lastName", "email",
                "phoneNumber","password", "address");
        assertEquals(1, eShoppingMall.getTotalNumberOfUser());

        User newUser = eShoppingMall.canFindARegisterUser("email");
        assertEquals("email", newUser.getEmail());
        Cart cart = eShoppingMall.canCreateCartForUser();
        assertEquals(0, cart.count());
        eShoppingMall.canAddItemsToCart("name", bigDecimal = new BigDecimal("0.00"), 0);
        assertEquals(1, cart.count());
    }

    @Test
    public void testThatEcommerceAppCanGiveACartTToARegisterUserAndARegisterUserCanAddItemsTwiceAndRemoveOnceTest(){
        eShoppingMall.canRegisterUser("firstName", "lastName", "email",
                "phoneNumber","password", "address");
        assertEquals(1, eShoppingMall.getTotalNumberOfUser());
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

    @Test
    public void testThatEcommerceAppCanHaveListOfItemsFound(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Bread");
        list.add("Water");
        list.add("Pen");
        list.add("Cake");
        list.add("Sweet");

        String[] result = eShoppingMall.canHaveListOfItems(list);
        assertEquals("Bread", result[0]);
        assertEquals("Water", result[1]);
        assertEquals("Pen", result[2]);
        assertEquals("Cake", result[3]);
        assertEquals("Sweet", result[4]);
        assertEquals(5, result.length);
    }
}
