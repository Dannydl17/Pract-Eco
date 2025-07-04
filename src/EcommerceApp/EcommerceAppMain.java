package EcommerceApp;

import java.math.BigDecimal;
import java.util.Scanner;

import static java.lang.System.in;

public class EcommerceAppMain {
    private static Ecommerce eShoppingMall = new Ecommerce("EShoppingMall");
    private static Scanner keyboardInput = new Scanner(in);

    public static void main(String[] args) {
        EcommerceMainMenu();
    }

    private static void EcommerceMainMenu() {
        String menu = """
                Welcome To EShopping Mail
                =========================
                1 -> Register
                2 -> AddItem
                3 -> RemoveItem
                4 -> Exit
                ==================
                """;
        String response = input(menu);
        services(response);
    }

    private static void services(String response) {
        switch(response){
            case "1" -> register();
            case "2" -> addItem();
            case "3" -> removeItem();
            case "4" -> exit();
        }
    }


    private static String input(String menu) {
        System.out.println(menu);
        return keyboardInput.nextLine();
    }

    private static void register() {
        String firstName =  input("Enter your firstname: ");
        String lastName =  input("Enter your lastname: ");
        String email =  input("Enter your email: ");
        String phoneNumber =  input("Enter your phoneNumber: ");
        String password = input("Enter your password: ");
        String address = input("Enter your address: ");
        System.out.println(eShoppingMall.canRegisterUser(firstName, lastName, email, phoneNumber, password, address));
//        EcommerceMainMenu();
    }

    private static void addItem() {
        String itemName =  input("Enter the item name: ");
        BigDecimal price = new BigDecimal(input("Enter ya amount: "));
        int quantity = Integer.parseInt(input("Enter ya quantity: "));
        eShoppingMall.canAddItemsToCart(itemName, price, quantity);
    }

    private static void removeItem() {
        String itemName =  input("Enter the item name: ");

    }

    private static void exit() {
        System.exit(9);
    }
}
