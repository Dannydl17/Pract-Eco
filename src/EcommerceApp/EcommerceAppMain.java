package EcommerceApp;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class EcommerceAppMain {
    private static Ecommerce eShoppingMall = new Ecommerce("EShoppingMall");
    private static Item[] item;

    private static User user;
    private static Scanner keyboardInput = new Scanner(in);

    public static void main(String[] args) {
        EcommerceMainMenu();
    }

    private static void EcommerceMainMenu() {
        String menu = """
                Welcome To EShopping Mail
                =========================
                1 -> Register
                2 -> FindUser
                3 -> CreateItems
                4 -> SearchForItem
                5 -> AddItem
                6 -> RemoveItem
                7 -> Exit
                ==================
                """;
        String response = input(menu);
        services(response);
    }

    private static void services(String response) {
        switch(response){
            case "1" -> register();
            case "2" -> findUser();
            case "3" -> createItems();
            case "4" -> searchForItems();
            case "5" -> viewItems();
            case "6" -> addItem();
            case "7" -> removeItem();
            case "8" -> exit();
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
        System.out.println
        (eShoppingMall.registerUser(firstName, lastName, email,
        phoneNumber, password, address));
//        EcommerceMainMenu();
    }

    private static void findUser() {
        String email =  input("Enter your email: ");
        user = eShoppingMall.findARegisterUser(email);
    }

    private static void createItems() {
        String itemName =  input("Enter item name: ");
        String itemAmount =  input("Enter ya amount: ");
        int quantity = Integer.parseInt(input("Enter the number of quantity: "));
        eShoppingMall.createItems(itemName, new BigDecimal(itemAmount), quantity);
    }

    private static void searchForItems() {
        String itemName =  input("Enter item name: ");
        String items = eShoppingMall.searchForItem(itemName);
        System.out.print(items);
    }

    private static void viewItems() {

    }

    private static void addItem() {
        String itemName =  input("Enter the item name: ");
        BigDecimal price = new BigDecimal(input("Enter ya amount: "));
        int quantity = Integer.parseInt(input("Enter ya quantity: "));
        eShoppingMall.addItemsToCart(itemName, price, quantity);
    }

    private static void removeItem() {
        String itemName =  input("Enter the item name: ");
        eShoppingMall.removeItem(itemName);
    }

    private static void exit() {
        System.exit(9);
    }
}
