package EcommerceApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private User user;

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
}
