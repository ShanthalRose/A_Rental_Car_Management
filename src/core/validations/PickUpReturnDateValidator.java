package core.validations;

import entities.concretes.Reservation;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PickUpReturnDateValidator {

    boolean isDigit;
    LocalDate temporalDate;

    public LocalDate getPickUpValidDate() {

        LocalDate date = null; LocalDate.now();

        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        int year, month, day;
        System.out.println("Please enter the date you will receive the vehicle as day / month / year (31/01/2021).");

        do {
            isDigit = false;

            System.out.print(" year: ");
            try {
                year = scanner.nextInt();
                System.out.print(" month: ");
                month = scanner.nextInt();
                System.out.print("day: ");
                day = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("The values you enter must be numbers.");
                scanner.nextLine();
                isDigit = true;
                continue;
            }
            try {
                date = LocalDate.of(year,month,day);
            } catch (Exception e) {
                System.out.println(" Please enter a valid date.");
                isDigit = true;
            }

            if (date.isBefore(LocalDate.now())) {
                System.out.println("The reservation date cannot be earlier than today!");
                isDigit = true;
            }

        } while (isDigit);
        temporalDate = date;
        return date;
    }

    public LocalDate getReturnValidDate() {

        @SuppressWarnings("unused")
		Reservation reservation = new Reservation();

        LocalDate returnDate = null;
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        int year, month, day;
        //System.out.println("Please enter the date you will deliver the vehicle as day / month / year (31/01/2021).");

        do {
            isDigit = false;

            System.out.print(" year: ");
            try {
                year = scanner.nextInt();
                System.out.print(" month : ");
                month = scanner.nextInt();
                System.out.print(" day : ");
                day = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("The values you enter must be numbers.");
                scanner.nextLine();
                isDigit = true;
                continue;
            }
            try {
                returnDate = LocalDate.of(year, month, day);
            } catch (Exception e) {
                System.out.println("Please enter a valid date.");
                isDigit = true;
            }

            /*try {
                if (temporalDate.isBefore(returnDate)) {
                    isDigit = false;
                }
            } catch (Exception e) {
                System.out.println("The delivery date cannot be earlier than the booking date!");
                isDigit = true;
            }*/

        } while (isDigit);

        return returnDate;
    }

	
	}

	
	
/* public static void main(String[] args) {
getPickUpValidDate();
    getReturnValidDate(getPickUpValidDate());}
}*/
