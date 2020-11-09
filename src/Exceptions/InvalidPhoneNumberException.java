package Exceptions;

public class InvalidPhoneNumberException extends Exception {
    public void printErrorMessage() {
        System.out.println("Phone number must contain 8 digits");
    }
}
