package EcommerceApp;

import EcommerceApp.exception.InvalidItemName;
import EcommerceApp.exception.UserNotFound;

import java.math.BigDecimal;
import java.util.ArrayList;

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

    public String[] canHaveListOfItems(ArrayList<String> list) {
        ItemFound itemFound = new ItemFound();
        String[] results = new String[list.size()];
        for (int index = 0; index < results.length; index++) {
            results[index] = String.valueOf(list.get(index));
        }

        results = itemFound.canAddItems(results);
        return results;
    }

}
