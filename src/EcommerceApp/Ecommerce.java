package EcommerceApp;

import EcommerceApp.exception.UserNotFound;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class Ecommerce {
    private int numberOfUser;
    private ArrayList<User> users;

    public Ecommerce(String name){
        users = new ArrayList<>();
    }

    public void canRegisterUser(String firstName, String lastName, String email,
                                String phoneNumber, String password, String address) {
        numberOfUser++;
        User user = new User(firstName, lastName, email, phoneNumber, password, address);
        users.add(user);
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

    public Cart canCreateCartForUser() {
        User user = canFindARegisterUser("email");
        Cart cart = user.canHaveACart();
        return cart;
    }

    public void canAddItemsToCart(String name, BigDecimal bigDecimal, int numb) {
        Item item = new Item(name, bigDecimal, numb);
        User user = canFindARegisterUser("email");
        user.add(item);
    }

    public void canRemoveItem(String name) {
        User user = canFindARegisterUser("email");
        user.canRemoveItem(name);
    }

    public String[] canHaveStoredItems(String[] items) {
        StoreItem storeItem = new StoreItem(items);
        String[] r = storeItem.getItemFounds();
        System.out.println(Arrays.toString(r));
        return r;
    }


//    public String[] canHaveListOfItems(String element) {
//        StoreItem itemFound = new StoreItem();
//        String[] results = new String[element.length()];
//        for (int index = 0; index < results.length; index++) {
//            results[index] = element[index];
//        }
//
//        results = itemFound.canAddItems(results);
//        return results;
//    }

}
