package business.concretes;

import java.util.Scanner;

import business.abstracts.MenuService;

public class MenuManager extends MenuService {


    @Override
    public void getSelectionMenu() {

        HondaMenuManager hondaMenuManager = new HondaMenuManager();
        AudiMenuManager audiMenuManager = new AudiMenuManager();
        BmwMenuManager bmwMenuManager = new BmwMenuManager();

        int select;
        @SuppressWarnings("resource")
		Scanner inp = new Scanner(System.in);

        System.out.println("Please enter the brand of the vehicle you want to rent");
        System.out.println("1-Honda");
        System.out.println("2-Audi");
        System.out.println("3-BMW");
    
        select = inp.nextInt();

        switch (select) {
            case 1:
                hondaMenuManager.hondaMenu();
                break;
            case 2:
                audiMenuManager.audiMenu();
            case 3:
                bmwMenuManager.bmwMenu();
           
        }
    }

    @Override
    public void search() {

    }

    @Override
    public void addCarsNewList() {


    }

}
