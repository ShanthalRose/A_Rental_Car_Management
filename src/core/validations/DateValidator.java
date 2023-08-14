package core.validations;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DateValidator {

    @SuppressWarnings("resource")
	public LocalDate getValidDate() {

        Scanner scanner = new Scanner(System.in);
        LocalDate date = null; //LocalDate.now();
        int year, month, day;
        System.out.println("Please enter your date as year / month / day (2023/01/12)");
        boolean isDigit;
        do {
            isDigit = false;
            System.out.print(" year: ");
            try {
                year = scanner.nextInt();
                System.out.print(" month : ");
                month = scanner.nextInt();
                System.out.print(" date: ");
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
        } while (isDigit);

        return date;
    }
}
