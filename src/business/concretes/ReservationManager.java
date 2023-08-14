package business.concretes;

import java.util.Scanner;

import business.abstracts.ReservationService;
import core.helpers.GetInvoice;
import core.helpers.GetReservation;
import core.helpers.IdMaker;
import core.helpers.Slow;
import core.validations.DateValidator;
import core.validations.PickUpReturnDateValidator;
import core.validations.TimeValidator;
import entities.abstracts.Cars;
import entities.abstracts.Users;
import entities.concretes.Reservation;

public class ReservationManager extends ReservationService implements IdMaker {

    public static int number = 1;
    Scanner scanner = new Scanner(System.in);

    Reservation reservation = new Reservation();

    ReservationCostCalculateManager costCalculateManager = new ReservationCostCalculateManager();
    DateValidator dateValidator = new DateValidator();
    PickUpReturnDateValidator pickUpDateValidator = new PickUpReturnDateValidator();
    TimeValidator timeValidator = new TimeValidator();
    GetReservation reservationCard = new GetReservation();
    GetInvoice getInvoice = new GetInvoice();

    public void reservationConfirmation() {
        System.out.println("***************     BOOKING CONFIRMATION      ***************************\n");
        System.out.println("Welcome to the reservation confirmation section!");
        
        /*System.out.println("Please enter the city name where you will pick up the vehicle: ");
        reservation.setPickUpLocation(scanner.nextLine().toUpperCase());

        System.out.println("Please enter the date you will receive the vehicle (in year/Month/date format): ");
        reservation.setPickUpDate(pickUpDateValidator.getPickUpValidDate());

        System.out.println("Please enter the time (in Hour:Minute format) that you will receive the vehicle:");
        reservation.setPickUpTime(timeValidator.getValidTime());
        reservation.setPickUpTime(LocalTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("HH:mm")));*/

        System.out.println("Please enter the city name to which you will deliver the vehicle:");
        reservation.setReturnLocation(scanner.nextLine().toUpperCase());

        System.out.println("Please enter the date you will deliver the vehicle (in Year/Month/date format): ");
        reservation.setReturnDate(pickUpDateValidator.getReturnValidDate());

        System.out.println("Please enter the time (in Hour:Minute format) that you will receive the vehicle:");
        reservation.setReturnTime(timeValidator.getValidTime());
       // reservation.setReturnTime(LocalTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("HH:mm")));

       reservation.setReservationId(idMaker(String.valueOf(number)));
       number++;

        System.out.println("=========================================================================================================");
        String message = "Your reservation is being billed!\n";
        Slow.slowPrint(message, 100);
        System.out.println();

        //reservationCard.addReservationToList(reservation);

        //getInvoice.Invoice();
        //getInvoice.Invoice();

        //CustomerService.setFirstName(NameValidator());
    }

    @Override
    public Cars car() {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
        return null;
    }

    @Override
    public Users user() {
        return null;
    }

    @Override
    public String idMaker(String number) {

        String suffix = "INVOICE-0";


        return suffix + number; //INVOICE-01231000
    }
}
