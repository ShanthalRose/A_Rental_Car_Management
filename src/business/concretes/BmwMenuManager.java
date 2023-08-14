package business.concretes;

import business.abstracts.CarService;
import core.helpers.GetCar;
import core.helpers.Slow;
import entities.concretes.Bmw;
import java.util.Scanner;

public class BmwMenuManager extends MenuManager implements CarService {

    Scanner inp = new Scanner(System.in);
    Bmw bmw = new Bmw(); //DI (Dependeny Injection) --> Don't repeat yourself (DRY)  - SOLID
    CustomerManager customerManager = new CustomerManager();
    GetCar getCar = new GetCar();

    public void bmwMenu() {
        String select;

        bmw.fillBmwList();
        bmw.showAvailableCars(true);

//        System.out.println("=================== InactiveCars ==============");
//        bmw.showInactiveCars(false);

        System.out.println("==================================VEHICLE SELECTION=============================================\n");
        System.out.println("Press 'Q' to finish booking, any key to continue");
        select = inp.nextLine();

        if (select.equalsIgnoreCase("Q")) {
            getSelectionMenu();
        }

        System.out.print("Please enter the code of the car you want to rent:");
        System.out.println();
        getCar.getBmw();

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
            for (Bmw w : bmw.bmwList) {

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


    public void BmwList() {

        int select;
        @SuppressWarnings("resource")
		Scanner inp = new Scanner(System.in);

        System.out.println("Please enter the number of the vehicle list you want to view");
        System.out.println("1-Only available vehicles");
        System.out.println("2-Only reserved vehicles");
        System.out.println("3-all vehicles");
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


    @Override
    public void availableCarsList() {
        bmw.showAvailableCars(true);
    }

    @Override
    public void reservedCarsList() {
        bmw.showInactiveCars(false);
    }

    @Override
    public void allCarsList() {
        bmw.fillBmwList();
    }

    @Override
    public void unAvailableCarsList() {

    }
}

