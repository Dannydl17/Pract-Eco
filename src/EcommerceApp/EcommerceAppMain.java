package EcommerceApp;

import java.util.Scanner;

import static java.lang.System.in;

public class EcommerceAppMain {
    private static Ecommerce eShoppingMall = new Ecommerce("EShoppingMall");
    private static Scanner keyboardInput = new Scanner(in);
    public static void main(String[] args) {
       gotoMain();
    }
    private static void gotoMain(){
        String prompt =
                """
                ===============================
                Welcome To EShopping Mall App
                ===============================
                Press
                1 -> RegisterUser
                2 -> FindARegister
                3 -> AddItem
                4 -> RemoveItem
                5 -> 
                6 ->
                7 -> 
                ================================
                """;
        System.out.println(prompt);
        System.out.println("Choose an option you want:   ");
        int userInput = keyboardInput.nextInt();
        switch (userInput){
            case 1 -> canRegisterUser();
            case 2 -> canFindAUser();
            case 3 -> canAddItem();
//            case 4 ->
//            case 5 ->
//            case 6 ->
//            case 7 ->
        }
    }

    private static void canRegisterUser() {
        System.out.println("Enter ya firstname: ");
        String fName = keyboardInput.next();
        System.out.println("Enter ya lastname: ");
        String lName = keyboardInput.next();
        System.out.println("Enter ya email: ");
        String email = keyboardInput.next();
        System.out.println("Enter ya phoneNumber: ");
        String pNumber = keyboardInput.next();
        System.out.println("Enter ya passWord: ");
        String passWo = keyboardInput.next();
        System.out.println("Enter ya address: ");
        String address = keyboardInput.next();
        User user = eShoppingMall.canRegisterUser(fName, lName, email, pNumber, passWo, address);
        System.out.println("Registration was successful");
    }

    private static User canFindAUser() {
        User user = eShoppingMall.canFindARegisterUser(user.getEmail());
        return user;
    }

    private static void canAddItem() {
    }

    private static void canRemoveItem() {
    }
}
