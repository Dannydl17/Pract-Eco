package EcommerceApp;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class EcommerceAppMain {
    private static Ecommerce eShoppingMall = new Ecommerce("EShoppingMall");

    private static Item[] item;
    private static Scanner keyboardInput = new Scanner(in);

    public static void main(String[] args) {
        EcommerceMainMenu();
    }

    private static void EcommerceMainMenu() {
        String menu = """
                Welcome To EShopping Mail
                =========================
                1 -> Register
                2 -> SearchForItem
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
            case "2" -> searchForItems();
            case "3" -> addItem();
            case "4" -> removeItem();
            case "5" -> exit();
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

    private static void createItems() {
        String itemName =  input("Enter item name: ");
        String itemAmount =  input("Enter ya amount: ");
        int quantity = Integer.parseInt(input("Enter the number of quantity: "));
        eShoppingMall.createItems(itemName, new BigDecimal(itemAmount), quantity);
    }

    private static void searchForItems() {
        Item itemFst = new Item("Rice", new BigDecimal("50.00"), 1);

        Item itemScd = new Item("Bread", new BigDecimal("50.00"), 0);

        Item itemTd = new Item("Water", new BigDecimal("100.00"), 2);

        item = new Item[]{itemFst, itemScd, itemTd};
        eShoppingMall.storedItems(item);

        String itemName =  input("Enter item name: ");
        String[] item = eShoppingMall.searchForItem(itemName);

        for (int count = 0; count < item.length; count++) {
            System.out.print(item[count] + " ");
        }
    }

    private static void addItem() {
        String itemName =  input("Enter the item name: ");
        BigDecimal price = new BigDecimal(input("Enter ya amount: "));
        int quantity = Integer.parseInt(input("Enter ya quantity: "));
        eShoppingMall.addItemsToCart(itemName, price, quantity);
    }

    private static void removeItem() {
        String itemName =  input("Enter the item name: ");
    }

    private static void exit() {
        System.exit(9);
    }
}
