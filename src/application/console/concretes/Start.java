package application.console.concretes;

import business.concretes.CustomerManager;
import business.concretes.MenuManager;
import business.concretes.ReservationManager;
import core.helpers.GetInvoice;

import java.util.Scanner;

public class Start {

    @SuppressWarnings("resource")
	public static void start(GetInvoice getInvoice){

        Scanner inp = new Scanner(System.in);

        MenuManager menuManager = new MenuManager();
        CustomerManager customerManager = new CustomerManager();
        ReservationManager reservationManager = new ReservationManager();

        int select;

        do {
            System.out.println("#########@@@ WELCOME TO MY MINIPROJECT RENT A CAR MANAGEMENT SYSTEM @@@###########\n");
            System.out.println("1- Brand Select ");
            System.out.println("2- Registration ");
            System.out.println("3- Confirm Reservation ");
            System.out.println("4- Exit");
            @SuppressWarnings("unused")
			Scanner scanner = new Scanner(System.in); 
    			System.out.println("enter the option");
            select = inp.nextInt();

            switch (select){
                case 1:
                    menuManager.getSelectionMenu();
                   
                    break;
                case 2:
                    customerManager.register();
                    break;
                case 3:
                    reservationManager.reservationConfirmation();
                    break;
               
                case 4:
                	System.out.println("              THANK YOU FOR BOOKING!!!!               ");
                    break;
                
                default:
                    System.out.println("You have entered incorrectly!");
                    break;
            }   



        }while(select != 4);

        System.out.println("Good day, we are waiting for you again...");
    }

}
