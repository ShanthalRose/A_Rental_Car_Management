package business.concretes;

import business.abstracts.CarService;
import core.helpers.GetCar;
import core.helpers.Slow;
import entities.concretes.Honda;


import java.util.Scanner;

import application.console.Start;

@SuppressWarnings("unused")
public class HondaMenuManager extends MenuManager implements CarService {

    Scanner inp = new Scanner(System.in);
    Honda honda = new Honda(); //DI (Dependeny Injection) --> Don't repeat yourself (DRY)  - SOLID
    CustomerManager customerManager = new CustomerManager();
    GetCar getCar = new GetCar();

    public void hondaMenu() {
        String select;

        honda.fillHondaList();
        honda.showAvailableCars(true);

//        System.out.println("=================== InactiveCars ==============");
//        honda.showInactiveCars(false);

        System.out.println("================================== VEHICLE SELECTION =============================================\n");


        System.out.println("Press 'Q' to finish the reservation process, press any key to continue");
        select = inp.nextLine();

        if (select.equalsIgnoreCase("Q")) {
            getSelectionMenu();
        }

        System.out.print("Please enter the code of the car you want to rent:");
        System.out.println();
        getCar.getHonda();

        System.out.println();
        String s = "==> You are being redirected to the customer registration menu...\\n\\n";
        Slow.slowPrint(s, 30);
        customerManager.register();
    }

    @Override
    public void search() {
        int flag = 0;
        String id;

        do {
            id = inp.nextLine();
            for (Honda w : honda.hondaList) {

                if (w.getId().equals(id)) {
                    w.showAvailableCars(true);
                    flag++;
                    break;
                }
            }

            if (flag == 0) {
                System.out.println("No vehicle found matching the entered code!");
            } else {
                System.out.println("Successfully registered");
                break;
            }
        } while (true);
    }


    @SuppressWarnings("resource")
	public void hondaListMenu() {

        int select;
        Scanner inp = new Scanner(System.in);

        System.out.println("Please enter the number of the vehicle list you want to view");
        System.out.println("1-Only available vehicles");
        System.out.println("2-Only reserved vehicles");
        System.out.println("3-All vehicles");
        System.out.println("0-Main menu");
        select = inp.nextInt();

        switch (select) {
            case 1:
                this.availableCarsList();
                break;
            case 2:
                this.reservedCarsList();
            case 3:
                this.allCarsList();
            
        }


    }



    public void availableCarsList() {
        honda.showAvailableCars(true);
    }

    @Override
    public void reservedCarsList() {
        honda.showInactiveCars(false);
    }

    @Override
    public void allCarsList() {
        honda.fillHondaList();
    }

    @Override
    public void unAvailableCarsList() {

    }
}
