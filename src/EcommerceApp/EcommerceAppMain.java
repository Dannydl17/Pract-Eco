package EcommerceApp;

import java.math.BigDecimal;
import java.util.Scanner;

import static java.lang.System.in;

public class EcommerceAppMain {
    private static Ecommerce eShoppingMall = new Ecommerce("EShoppingMall");
    private static Scanner keyboardInput = new Scanner(in);

    private static void canRegisterUser(String fName, String lName, String email,
                                        String pNumber, String passWo, String address) {
        eShoppingMall.canRegisterUser(fName, lName, email, pNumber, passWo, address);
        System.out.println("Registration was successful");
    }

    private static User canFindAUser(String email) {
        User user = eShoppingMall.canFindARegisterUser(email);
        return user;
    }

    private static void canAddItem(String name, BigDecimal bigDecimal, int numb) {
        eShoppingMall.canAddItemsToCart(name, bigDecimal, numb);
    }

    private static void canRemoveItem(String name) {
        eShoppingMall.canRemoveItem(name);
    }
}
