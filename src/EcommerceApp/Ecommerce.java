package EcommerceApp;

import EcommerceApp.exception.InvalidItem;
import EcommerceApp.exception.UserNotFound;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

public class Ecommerce {
    private int numberOfUser;
    private  SecureRandom randomNumber;
    private int numberOfItem;
    private int numberOfItemStored;
    private ArrayList<User> users;
    private ArrayList<Item> items;
    private Cart cart;

    public Ecommerce(String name) {
        users = new ArrayList<>();
        items = new ArrayList<>();
    }

    public String registerUser(String firstName, String lastName,
                          String email, String phoneNumber,
                          String password, String address) {


        String word;
        try {
            findARegisterUser(email);
            word = "User already exists";
        }
        catch (UserNotFound ex){
            User newUser = new User(firstName, lastName, email, phoneNumber, password, address);
            users.add(newUser);
            numberOfUser++;
             word = "Account created";
        }

        return word;
    }

    public int getTotalNumberOfUser() {
        return numberOfUser;
    }

    public User findARegisterUser(String email) {
        for (User user: users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        throw new UserNotFound("User not found");
    }

    public String createItems(String name, BigDecimal amount, int quantity) {
        String word;
        Item item = new Item(name, amount, quantity);
        items.add(item);
        numberOfItem++;
        word = "Item Added";

        return word;
    }

    private Item findItemByName(String name) {
        for (Item item: items) {
            if (item.getItemName().equals(name)) {
                return item;
            }
        }
        throw new InvalidItem("Item not found");
    }

    public int getTotalNumberOfItems() {
        return numberOfItem;
    }


    public String[] searchForItem(String itemName) {

        String name = null;
        String price = null;
        int quantity = 0;


        try {
            Item item = findItemByName(itemName);
            if (item.getItemName() == itemName) {
                name = item.getItemName();
                price = item.getPrice();
                quantity = item.getQuantity();
            }
        }
        catch (InvalidItem ex){
            randomNumber = new SecureRandom();
            int numberGuess = 1 + randomNumber.nextInt(12);
            createItems(itemName, new BigDecimal("0.00"), numberGuess);
        }

        return storeInArray(name , price, quantity);
    }

    private String[] storeInArray(String name, String price, int quantityN) {
        ArrayList<String> result = new ArrayList<>();
        result.add(name);
        result.add(price);
        result.add(String.valueOf(quantityN));

      return convertToArray(result);
    }

    private String[] convertToArray(ArrayList<String> result) {
        String[] results = new String[result.size()];
        for (int index = 0; index < results.length; index++) {
            results[index] = result.get(index);
        }
        return results;
    }

    public Cart createCart () {
        cart = new Cart();
        return cart;
    }

    public void addItemsToCart(String name, BigDecimal bigDecimal, int numb) {
        Item item = new Item(name, bigDecimal, numb);
        cart.add(item);

    }

    public void removeItem(String name) {
        cart.Remove(name);
    }
}
