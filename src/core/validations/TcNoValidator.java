
package core.validations;

import java.util.Scanner;

public class TcNoValidator {

    public String getValidTcNumber() {

        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        String tcNo = "";

        do {
            tcNo = scanner.next();
            String x = tcNo.replaceAll("[\\d]", "");

            if (!x.isEmpty()) {
                System.out.println("Do not enter characters other than numbers!");
                System.out.println("Try again");
            }

            else if (tcNo.length() != 11) {
                System.out.println("TR ID number must consist of 11 characters.");
                System.out.println("Try again");
            }
            else{
                break;
            }


        } while (true);

        return tcNo;
    }

}
