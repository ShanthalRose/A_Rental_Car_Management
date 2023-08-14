package core.helpers;


import business.concretes.ReservationCostCalculateManager;
import entities.abstracts.Cars;
import entities.concretes.Customers;
import entities.concretes.Reservation;

public class GetInvoice {

    GetReservation reservationCard = new GetReservation();

    public static int index = 0;
    CalculateDay calculateDay = new CalculateDay();
    
    ReservationCostCalculateManager rccm = new ReservationCostCalculateManager();

    public void Invoice() {

        Customers cus = GetReservation.reservedCustomers.get(index);
        Reservation res = GetReservation.reservations.get(index);
        Cars car = GetReservation.reservedCars.get(index);

        System.out.println("===============CUSTOMER INFORMATION ================");
        System.out.printf("%-11s  %-15s  %-15s  %-11s  %-15s  %-25s \n", "Customer ID", "Name", "Surname", "TC No", "Date of Birth", "Date of License Issue");
        System.out.printf("%-11s  %-15s  %-15s  %-11s  %-15s  %-25s \n", "-----------", "--------------", "-------------", "-----------", "--------------", "--------------------------");
        System.out.printf("%-11s  %-15s  %-15s  %-11s  %-15s  %-25s\n", cus.getId(), cus.getFirstName(), cus.getLastName(), cus.getTcNo(), cus.getBirthDate(), cus.getDriverLicenceDate());
        System.out.println();

        System.out.println("============= RESERVATION INFORMATION==============");
        System.out.printf("%-17s  %-15s  %-13s  %-13s  %-15s  %-15s %-15s %-9s\n", "Booking ID", "Pickup Place", "Pickup Date", "Pickup Time", "Pickup Place", "Delivery Date", "Delivery Time", "Total Amount");
        System.out.printf("%-17s  %-15s  %-13s  %-13s  %-15s  %-15s %-15s %-9s\n", "---------------", "---------------", "-------------", "-----------", "--------------", "--------------", "------------", "------------");
        System.out.printf("%-17s  %-15s  %-13s  %-13s  %-15s  %-15s %-15s $%-8s\n", res.getReservationId(), res.getPickUpLocation(), res.getPickUpDate(), res.getPickUpTime(), res.getReturnLocation(), res.getReturnDate(), res.getReturnTime(),priceCalculate());
        System.out.println();

        System.out.println("================= VEHICLE INFORMATION ==================");
        System.out.printf("%-13s  %-10s  %-13s  %-10s  %-14s  %-12s %-15s\n","Vehicle Code","Brand","Model","Model Year","Auto Transmission","Fuel Type","Daily Price");
        System.out.printf("%-13s  %-10s  %-13s  %-10s  %-14s  %-12s %-15s\n","-----------","--------","---------","----------","--------------","----------","------------");
        System.out.printf("%-13s  %-10s  %-16s  %-10s  %-12s  %-12s $%-14s\n",car.getId(),car.getBrandName(),car.getModel(),car.getModelYear(),car.isGear(),car.getFuelType(),car.getDailyPrice());

        index++;
        System.out.println();
        System.out.println("Thank you for choosing us");
    }

    private double priceCalculate() {
        int day = calculateDay.calculate(GetReservation.reservations.get(index).getPickUpDate(), GetReservation.reservations.get(index).getReturnDate());
        
        double price= GetReservation.reservedCars.get(index).getDailyPrice();
        
        if (day<7){

           return rccm.getOneWeekPrice(day,price);

        } else if (day<15) {

            return rccm.getTwoWeeksPrice(day,price);

        }else{

            return rccm.getMoreThanTwoWeeksPrice(day,price);
        }

    }

}
