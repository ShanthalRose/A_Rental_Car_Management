package core.validations;

import core.helpers.Slow;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

@SuppressWarnings("unused")
public class DriverLicenceValidator {

    public boolean driverLicenceEligibility(LocalDate birthday, LocalDate licenceDay) { //Ehliyet uygun mu

        boolean isValid = false;

        //DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd-MM-yy");//09-42 ös şimdiki saatin formatını değiştirdim

        int validBirthDate = (int) ChronoUnit.YEARS.between(birthday, LocalDate.now());
        //System.out.println(validBirthDate);

        int validLicenceDate = (int) ChronoUnit.YEARS.between(licenceDay, LocalDate.now());
        // System.out.println(validLicenceDate);

        do {

            if (validBirthDate < 18 || validBirthDate > 100) {
                System.out.println("Please enter a valid age!");
                System.out.println("Try again: ");
                break;

            } else if (validLicenceDate < 3) {
                System.out.println("You must have at least 3 years of experience to rent a car!");
                System.out.println();
                break;
            } else {
                String message = "The duration of the driver's license has been deemed appropriate for renting a car.";
                Slow.slowPrint(message, 30);
                isValid = true;
                break;
            }

        } while (true);

        return isValid;
    }
}

