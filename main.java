import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.*;

public class main {


    public static void main(String[] args) throws IOException {


        Scanner input = new Scanner(System.in);
        String pathToProducts = "";
        String pathToEmployees = "";
        BufferedReader csvProducts = null;
        BufferedReader csvEmployees = null;
        Hashtable<Integer, Hashtable<String, String>> employees = null;
        Hashtable<Integer, Hashtable<String, String>> products = null;
        while (true) {
            System.out.println("Input path to Products file:");
            pathToProducts = input.nextLine();
            System.out.println("Input path to Employees file:");
            pathToEmployees = input.nextLine();
            try {
                csvProducts = new BufferedReader(new FileReader(pathToProducts));
                products = Parser.getProductsList(csvProducts);

                csvProducts.close();

                csvEmployees = new BufferedReader(new FileReader(pathToEmployees));
                employees = Parser.getEmployeesList(csvEmployees);
                csvEmployees.close();

                break;
            } catch (FileNotFoundException e) {
                System.out.println("invalid path, try again");

            }

        }


        Hashtable<Integer, String> employeeTable = Parser.csvParser(employees);

        String userType = "";

        while (!(userType.toLowerCase().equals("employee") || userType.toLowerCase().equals("customer"))) {

            System.out.println("Input user type (Employee or Customer):");
            userType = input.nextLine();


        }
        if (userType.toLowerCase().equals("employee")) {
// prochitame csv fila i edin wile loop za empID i name

            String employeeIDs = "";
            String employeeName = "";
            while (true) {
                System.out.println("Input employee ID: ");

                employeeIDs = input.nextLine();
                System.out.println("Input employee First name: ");
                employeeName = input.nextLine();
                int employeeID = Integer.parseInt(employeeIDs);
                if (employeeTable.containsKey(employeeID) && employeeTable.get(employeeID).equals(employeeName)) {
                    System.out.println("Login successful");
                    break;
                } else {
                    System.out.println("Invalid ID or name. Try again...");
                }
            }
            //proverqvame empID and name gi ima vuv csv faila
            //ako gi ima se otvarq menu s opcii
            //ako gi nqma, otnowa se iska empID/name
            EmployeeWork.runProgram(products, employees);
        } else if (userType.toLowerCase().equals("customer")) {
            //pokazvame menu s opcii
        }
    }
}


//  C:\Users\David\IdeaProjects\magazin\src\Employee.csv
//  C:\Users\David\IdeaProjects\magazin\src\Products.csv