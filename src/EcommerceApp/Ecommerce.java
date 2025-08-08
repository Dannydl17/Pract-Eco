package EcommerceApp;

import EcommerceApp.exception.InvalidItem;
import EcommerceApp.exception.UserNotFound;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Ecommerce {
    private int numberOfUser;
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
        try {
            findItemByName(name);
            word = "Item exists";
        }
        catch (InvalidItem ex){
            Item item = new Item(name, amount, quantity);
            items.add(item);
            numberOfItem++;
            word = "Item Added";
        }

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

    public void storedItems(Item[] item) {
        for (int count = 0; count < item.length; count++) {
            Item n = item[count];
            items.add(n);
            numberOfItemStored++;
        }
    }

    public int getNumberOfItemStored(){
        return numberOfItemStored;
    }

    public String searchForItem(String itemName) {
        String word = null;
        for (int count = 0; count < items.size(); count++) {
             Item item = items.get(count);
            if (item.getItemName().equals(itemName)) {
                word = "Item already found";
            }
        }
        return word;
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
