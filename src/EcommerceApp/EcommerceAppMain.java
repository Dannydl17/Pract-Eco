package EcommerceApp;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;

public class EcommerceAppMain {
    private static Ecommerce eShoppingMall = new Ecommerce("EShoppingMall");

    private static ArrayList<Item> listItems = new ArrayList<>();
    private static Scanner keyboardInput = new Scanner(in);

    public static void main(String[] args) {
//        register();
//        findUser();
        EcommerceMainMenu();
        viewAllItems();
        searchForItems();
    }

    private static void EcommerceMainMenu () {
        String menu = """
                WELCOME TO ESHOPPING MALL
                =========================
                CreateItems
                SearchForItem
                ViewItems
                AddItem
                RemoveItem
                CheckOut
                9 -> Exit
                =========================
                """;
        System.out.println(menu);
    }

    private static void services(String response) {
        switch(response){
            case "9" -> exit();
        }
    }


    private static void register() {
        System.out.println("Enter your firstname: ");
        String firstName = keyboardInput.nextLine();

        System.out.println("Enter your lastname: ");
        String lastName = keyboardInput.nextLine();

        System.out.println("Enter your email: ");
        String email = keyboardInput.nextLine();

        System.out.println("Enter your phoneNumber: ");
        String phoneNumber = keyboardInput.nextLine();

        System.out.println("Enter your passWord: ");
        String password = keyboardInput.nextLine();

        System.out.println("Enter your address: ");
        String address = keyboardInput.nextLine();

        System.out.println
        (eShoppingMall.registerUser(firstName, lastName, email,
        phoneNumber, password, address));

    }

    private static void findUser() {
        System.out.println("Enter your email: ");
        String email = keyboardInput.nextLine();
        eShoppingMall.findARegisterUser(email);
    }

    private static void createItems() {
        System.out.println("Enter item name: ");
        String itemName = keyboardInput.nextLine();

        System.out.println("Enter ya amount: ");
        String itemAmount = keyboardInput.nextLine();

        System.out.println("Enter the number of quantity: ");
        int quantity = keyboardInput.nextInt();
        eShoppingMall.createItems(itemName, new BigDecimal(itemAmount), quantity);
    }

    private static void searchForItems() {
        System.out.println("Enter item name: ");
        String itemName = keyboardInput.nextLine();
        eShoppingMall.searchForItem(itemName);
    }

    private static void viewAllItems() {
      listItems = eShoppingMall.canViewListOfItems();
      int n = listItems.size();
      int counterN = 0;
      int counterP = 0;
      int counterQ = 0;

      String[]itemName = new String[n];

      String[]itemP = new String[n];

      int[]itemQ = new int[n];

      int count = 0;

       Item item =listItems.get(count);
       String name = item.getItemName();
       itemName[counterN] = name;

       String amount = item.getPrice();
       itemP[counterP] = amount;

       int quantity = item.getQuantity();
       itemQ[counterQ] = quantity;

        count++;
        counterN++;
        counterP++;
        counterQ++;

        while (count < listItems.size()){
            item =listItems.get(count);
            name = item.getItemName();
            itemName[counterN] = name;

            amount = item.getPrice();
            itemP[counterP] = amount;

            quantity = item.getQuantity();
            itemQ[counterQ] = quantity;

            count++;
            counterN++;
            counterP++;
            counterQ++;
        }

        for (int index = 0; index < itemName.length; index++) {
            System.out.print(itemName[index] + "      ");
        }
        System.out.println();
        for (int index = 0; index < itemP.length; index++) {
            System.out.print(itemP[index] + "    ");
        }
        System.out.println();
        for (int index = 0; index < itemQ.length; index++) {
            System.out.print(itemQ[index] + "           ");
        }
        System.out.println();
    }


    private static void addItem() {
        System.out.println("Enter the item name: ");
        String itemName = keyboardInput.nextLine();

        System.out.println("Enter ya amount: ");
        String amount = keyboardInput.nextLine();
        BigDecimal price = new BigDecimal(new BigInteger(amount));

        System.out.println("Enter ya quantity: ");
        int quantity = keyboardInput.nextInt();
        eShoppingMall.addItemsToCart(itemName, price, quantity);
    }

    private static void removeItem() {
        System.out.println("Enter the item name: ");
        String itemName = keyboardInput.nextLine();
        eShoppingMall.removeItem(itemName);
    }

    private static void checkOut() {

    }

    private static void exit() {
        System.exit(9);
    }
}
