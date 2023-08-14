package core.validations;

	import java.util.Scanner;

	public class NameValidator {

	    Scanner scan = new Scanner(System.in);

	    public String isValidFirstName() {
	        String firstName = "";
	        do {
	            firstName = scan.nextLine().trim();
	            String s = firstName.replaceAll("[a-zA-Z]", "");

	            if (!s.isEmpty()) {
	                System.out.println("No characters other than letters can be entered...");
	                System.out.println("Try again: ");
	            } else if (firstName.length() < 2 || firstName.length() > 20) {
	                System.out.println("Your name must contain at least 3 and no more than 20 letters...");
	                System.out.println("Try again: ");
	            } else {
	                firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
	                break;
	            }
	        } while (true);

	        return firstName;

	    }

	    public String isValidLastName() {
	        @SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);

	        String lastName = "";
	        do {
	            lastName = scan.nextLine().trim();
	            String s = lastName.replaceAll("[a-zA-Z]", "");
	            if (!s.isEmpty()) {
	                System.out.println("No characters other than letters can be entered...");
	                System.out.println("Try again:");
	            } else if (lastName.length() < 2 || lastName.length() > 30) {
	                System.out.println("Your surname must contain at least 3 and at most 30 letters...");
	                System.out.println("Try again: ");
	            } else {
	                lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
	                break;
	            }


	        } while (true);

	        return lastName;

	    }


	}


