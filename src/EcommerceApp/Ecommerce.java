package EcommerceApp;

import EcommerceApp.exception.InvalidItemName;
import EcommerceApp.exception.UserNotFound;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Ecommerce {

    private int numberOfUser;
    private ArrayList<User> users;
    private Cart cart;
    public Ecommerce(String name){
        users = new ArrayList<>();
        cart = new Cart();
    }

    public User canRegisterUser(String firstName, String lastName, String email,
                                String phoneNumber, String password, String address) {
        numberOfUser++;
        User user = new User(firstName, lastName, email, phoneNumber, password, address);
        users.add(user);
        return user;
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
        cart = user.canHaveACart();
        return cart;
    }

    public void canAddItemsToCart(String name, BigDecimal bigDecimal, int numb) {
        Item item = new Item(name, bigDecimal, numb);
        cart.add(item);
    }

}
