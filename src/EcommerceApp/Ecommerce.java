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

    public String canRegisterUser(String firstName, String lastName,
                          String email, String phoneNumber,
                          String password, String address) {


        String word = null;
        try {
            canFindARegisterUser(email);
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

    public User canFindARegisterUser(String email) {
        for (User user: users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        throw new UserNotFound("User not found");
    }

    public String canCreateItem(String name, BigDecimal amount, int quantity) {

        String word = null;
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

    public String canSearchForItem(String itemName) {
        Item foundItem = findItemByName(itemName);

        if(foundItem)
    }


    public Cart canCreateCart () {
        cart = new Cart();
        return cart;
    }

    public void canAddItemsToCart(String name, BigDecimal bigDecimal, int numb) {
        Item item = new Item(name, bigDecimal, numb);
        cart.add(item);

    }

    public void canRemoveItem(String name) {
        cart.Remove(name);
    }

}
