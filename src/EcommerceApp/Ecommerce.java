package EcommerceApp;

import java.util.ArrayList;

public class Ecommerce {

    private int numberOfUser;
    private ArrayList<User> users;

    public Ecommerce(String name){
        users = new ArrayList<>();
    }

    public User canRegisterUser(String firstName, String lastName, String email,
                            String phoneNumber, String password, String address) {
        numberOfUser++;
        String userFirstName = generateUserFirstName(firstName);
        String userLastName = generateUserLastName(lastName);
        String userEmail = generateUserEmail(email);
        String userPhoneNumber = generateUserPhoneNumber(phoneNumber);
        String userPassword = generateUserPassword(password);
        String userAddress = generateUserAddress(address);
        User user = new User(userFirstName, userLastName, userEmail,
                           userPhoneNumber, userPassword, userAddress);
        users.add(user);
        return user;
    }

    private String generateUserFirstName(String firstName) {
        return firstName;
    }
    private String generateUserLastName(String lastName) {
        return lastName;
    }
    private String generateUserEmail(String email) {
        return email;
    }
    private String generateUserPhoneNumber(String phoneNumber) {
        return phoneNumber;
    }
    private String generateUserPassword(String password) {
        return password;
    }
    private String generateUserAddress(String address) {
        return address;
    }

    public int getTotalNumberOfUser() {
        return numberOfUser;
    }
}
