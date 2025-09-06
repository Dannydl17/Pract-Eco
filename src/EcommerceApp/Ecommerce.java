package EcommerceApp;

import EcommerceApp.exception.InvalidItem;
import EcommerceApp.exception.UserNotFound;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;

public class Ecommerce {
    private int numberOfUser;
    private  SecureRandom randomNumber;
    private int numberOfItem;
    private ArrayList<User> users;
    private ArrayList<Item> items;
    private Cart cart;

    public Ecommerce(String name) {
        users = new ArrayList<>();
        items = new ArrayList<>();
        cart = new Cart();

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


    public Item searchForItem(String itemName) {
        storeItem();
        Item item = null;

        try {
            item = findItemByName(itemName);
        }
        catch (InvalidItem ex){
            String words = ex.getMessage();
            if (ex.getMessage().equals(words)) {
                System.out.println(words);
                itemNotFound(itemName);
            }

        }

        return item;
    }

    private void storeItem() {
        createItems("Rice", new BigDecimal("50.00"), 1);

        createItems("Bread", new BigDecimal("50.00"), 0);

        createItems("Water", new BigDecimal("100.00"), 2);
    }

    private void itemNotFound(String item) {
        randomNumber = new SecureRandom();
        int numberGuess = 1 + randomNumber.nextInt(12);
        createItems(item, new BigDecimal("0.00"), numberGuess);
    }

    private String foundItems(String name, String price, int quantity) {
        return name + "\n" +
               price + "\n" +
              quantity;
    }

    public Cart createCart () {
        return cart;
    }

    public void addItemsToCart(String name, BigDecimal amount, int numb) {
        Item item = new Item(name, amount, numb);
        cart.add(item);
    }

    public void removeItem(String name) {
        cart.Remove(name);
    }

    public ArrayList<Item> canViewListOfItems() {
        storeItem();
        return items;
    }
}
