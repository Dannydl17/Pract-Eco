package EcommerceApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CartTest {

    @Test
    public void testThatCartCanBeCreated(){
        Cart cart = new Cart();
        assertNotNull(cart);
    }
}
