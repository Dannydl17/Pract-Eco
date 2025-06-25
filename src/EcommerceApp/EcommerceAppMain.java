package EcommerceApp;

import EcommerceApp.exception.UserNotFound;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class EcommerceAppMain {
    private static Ecommerce eShoppingMall = new Ecommerce("EShoppingMall");
    private static Scanner keyboardInput = new Scanner(in);

    private static void canRegisterUser(String fName, String lName, String email,
                                        String pNumber, String passWo, String address) {
        try{
            eShoppingMall.canRegisterUser(fName, lName, email, pNumber, passWo, address);
            System.out.println("Registration was successful");
        }
        catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }
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
