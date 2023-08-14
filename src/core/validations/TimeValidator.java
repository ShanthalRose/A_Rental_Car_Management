package core.validations;

import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TimeValidator {

    @SuppressWarnings("resource")
	public LocalTime getValidTime() {

        Scanner scanner = new Scanner(System.in);
        LocalTime time = null;
        int hour,minute;
        @SuppressWarnings("unused")
		int second =0;
        //System.out.println("Please enter the time as hour / minute (10:00)");
        boolean isDigit;
        do {
            isDigit = false;
            System.out.print(" hour: ");
            try {
                hour= scanner.nextInt();
                System.out.print("minutes : ");
                minute = scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("The values you enter must be numbers.");
                scanner.nextLine();
                isDigit = true;
                continue;
            }
            try {
                time = LocalTime.of(hour, minute);
            } catch (Exception e) {
                System.out.println("Please enter a valid time.");
                isDigit = true;
            }
        } while (isDigit);

        return time;
    }
}
