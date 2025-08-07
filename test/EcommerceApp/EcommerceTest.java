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
    public void testThatEcommerceAppCanCreateItemsTest(){
        eShoppingMall.canRegisterUser("firstName", "lastName", "email",
                "phoneNumber","password", "address");
        assertEquals(1, eShoppingMall.getTotalNumberOfUser());

        eShoppingMall.canCreateItem("name", bigDecimal = new BigDecimal("0.00"), 0);
        assertEquals(1, eShoppingMall.getTotalNumberOfItems());
    }

    @Test
    public void testThatEcommerceAppCanStoreItemTest(){
        Item itemFst = new Item("Rice", new BigDecimal("50.00"), 1);
        Item itemScd = new Item("Bread", new BigDecimal("50.00"), 0);
        Item itemTd = new Item("Water", new BigDecimal("100.00"), 2);
        Item[] items = {itemFst, itemScd, itemTd};
        eShoppingMall.storedItems(items);
        assertEquals(3, eShoppingMall.getNumberOfItemStored());
    }

    @Test
    public void testThatEcommerceAppCanSearchForItemsTest(){
        String itemName = "Bread";
        String word = eShoppingMall.canSearchForItem(itemName);
    }

    @Test
    public void testThatEcommerceAppHaveACartTAndAddItemsTest(){
        eShoppingMall.canRegisterUser("firstName", "lastName", "email",
                "phoneNumber","password", "address");
        assertEquals(1, eShoppingMall.getTotalNumberOfUser());

        Cart cart = eShoppingMall.canCreateCart();
        assertNotNull(cart);

        eShoppingMall.canAddItemsToCart("name", bigDecimal = new BigDecimal("0.00"), 0);
        assertEquals(1, cart.count());
    }

    @Test
    public void testThatEcommerceAppHaveACartTAndAddItemsTwiceAndRemoveOnceTest(){
        eShoppingMall.canRegisterUser("firstName", "lastName", "email",
                "phoneNumber","password", "address");
        assertEquals(1, eShoppingMall.getTotalNumberOfUser());

        Cart cart = eShoppingMall.canCreateCart();
        assertEquals(0, cart.count());
        eShoppingMall.canAddItemsToCart("name", bigDecimal = new BigDecimal("0.00"), 0);
        assertEquals(1, cart.count());
        eShoppingMall.canAddItemsToCart("name", bigDecimal = new BigDecimal("0.00"), 0);
        assertEquals(2, cart.count());
        eShoppingMall.canRemoveItem("name");
        assertEquals(1, cart.count());
    }
}
