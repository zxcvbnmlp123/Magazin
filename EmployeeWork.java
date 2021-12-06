import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class EmployeeWork {

    public static List<Employee> sortEmployeesBySalary(List<Employee> pEmployees) {
        List<Integer> salaries = new ArrayList<Integer>();

        for (Employee p : pEmployees) {
            salaries.add(p.getSalary());
        }
        Collections.sort(salaries);

        List<Integer> indexes = new ArrayList<Integer>();
        for (int salary : salaries) {
            for (Employee p : pEmployees) {
                if (p.getSalary() == salary) {
                    int i = p.getId();
                    indexes.add(i);
                }
            }
        }
        List<Employee> sorted = new ArrayList<Employee>();
        for (int index : indexes) {
            for (Employee p : pEmployees) {
                if (p.getId() == index) {
                    sorted.add(p);

                }
            }
        }
        return sorted;
    }

    public static List<Employee> sortEmployeesByName(List<Employee> pEmployees) {
        List<String> names = new ArrayList<String>();
        System.out.println(pEmployees.size());
        for (Employee p : pEmployees) {
            names.add(p.getName());
        }
        names.sort(String::compareToIgnoreCase);

        List<Integer> indexes = new ArrayList<Integer>();
        for (String name : names) {
            for (Employee p : pEmployees) {
                if (p.getName().equals(name)) {
                    int i = p.getId();
                    indexes.add(i);
                }
            }
        }

        List<Employee> sorted = new ArrayList<Employee>();
        for (int index : indexes) {
            for (Employee p : pEmployees) {
                if (p.getId() == index) {
                    sorted.add(p);

                }
            }
        }
        return sorted;

    }

    public static Product getProductByNameAndID(int ID, String name, List<Product> pObjects) {
        List<String> names = new ArrayList<String>();

        for (Product p : pObjects) {
            if (p.id == ID && p.name.equals(name)) {
                return p;
            }
        }
        return null;

    }

    public static List<Product> sortProductsByExpDate(Hashtable<Integer, Hashtable<String, String>> products) {
        List<Product> sortedByDate = new ArrayList<Product>();  //
        List<String> dates = new ArrayList<String>();

//makeup food drinks
        // Parser.getProductObjects(products)
        Enumeration<Integer> e = products.keys();
        while (e.hasMoreElements()) { // minavamne prez ele ot hasht, proverqvame dali el imaa atr exxdate
            int key = e.nextElement();
            if (products.get(key).get("type").equals("makeup") || products.get(key).get("type").equals("food") || products.get(key).get("type").equals("drink")) {
                dates.add(products.get(key).get("expiredate")); //ako imat date gi dobawqme kujm dates lista

            } else {
                products.remove(key);
            }
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu"); //zadaame formata na datata
        Collections.sort(dates, (s1, s2) -> LocalDate.parse(s1, formatter).// sortirame dates lista
                compareTo(LocalDate.parse(s2, formatter)));
        for (String date : dates) { //vzimame edna data, namirame koi el ot hasht iam tazi data, suzdavame java obekt ot nego i go dobawqme kum sortedd by date lista, prmahvame el ot hsassht(ako imaa el s ednakuvv date)
            Enumeration<Integer> ee = products.keys();
            while (ee.hasMoreElements()) {
                int key = ee.nextElement();
                if (products.get(key).get("expiredate").equals(date)) { //
                    if (products.get(key).get("type").equals("food")) {
                        Food x = new Food(key, products.get(key).get("name"), Double.parseDouble(products.get(key).get("price")), Integer.parseInt(products.get(key).get("quantity")), products.get(key).get("expiredate"));
                        sortedByDate.add(x);
                        products.remove(key);
                        break;
                    } else if (products.get(key).get("type").equals("drink")) {
                        Drink x = new Drink(key, products.get(key).get("name"), Double.parseDouble(products.get(key).get("price")), Integer.parseInt(products.get(key).get("quantity")), products.get(key).get("expiredate"));
                        sortedByDate.add(x);
                        products.remove(key);
                        break;
                    } else if (products.get(key).get("type").equals("makeup")) {
                        Makeup x = new Makeup(key, products.get(key).get("name"), Double.parseDouble(products.get(key).get("price")), Integer.parseInt(products.get(key).get("quantity")), products.get(key).get("expiredate"), products.get(key).get("color"));
                        sortedByDate.add(x);
                        products.remove(key);
                        break;
                    }
                }
            }
        }
        return sortedByDate;
    }

    public static List<Product> sortProductsByPrice(List<Product> pObjects) {
        List<Double> prices = new ArrayList<Double>();

        for (Product p : pObjects) {
            prices.add(p.price);
        }
        Collections.sort(prices);
        System.out.println(prices);

        List<Integer> indexes = new ArrayList<Integer>(); //minavame prez lista s ceni, za vsqka edna cena, namirame obekta s tazi cena, zapisvame idto na prod v indexes
        for (Double price : prices) {
            for (Product p : pObjects) {
                if (p.price == price) {
                    int i = p.id;
                    indexes.add(i);
                }// minavame prezz lista s indexi i za vs el ot products namirame koi produkt ima tozi index i do dobavqme kum sorted
            }
        }
        List<Product> sorted = new ArrayList<Product>();
        for (int index : indexes) {
            for (Product p : pObjects) {
                if (p.id == index) {
                    sorted.add(p);

                }
            }
        }
        return sorted;
    }

    public static List<Product> sortProductsByName(List<Product> pObjects) {
        List<String> names = new ArrayList<String>();

        for (Product p : pObjects) {
            names.add(p.name);
        }
        names.sort(String::compareToIgnoreCase);
        System.out.println(names);
        List<Integer> indexes = new ArrayList<Integer>();
        for (String name : names) {
            for (Product p : pObjects) {
                if (p.name.equals(name)) {
                    int i = p.id;
                    indexes.add(i);
                }
            }
        }
        System.out.println(indexes);
        List<Product> sorted = new ArrayList<Product>();
        for (int index : indexes) {
            for (Product p : pObjects) {
                if (p.id == index) {
                    sorted.add(p);

                }
            }
        }
        return sorted;

    }

    public static void runProgram(Hashtable<Integer, Hashtable<String, String>> products, Hashtable<Integer, Hashtable<String, String>> employees) throws IOException {

        List<Employee> pEmployees = Parser.getEmployeeObjects(employees);// SAME

        List<Product> pObjects = Parser.getProductObjects(products);

        while (true) {
            int selection = employeeWork();
            if (selection == 1) {
                pObjects = Parser.getProductObjects(products);
                for (Product p : pObjects) { // za vseki predmet ot lista prodycts
                    System.out.println(p);
                }
                System.out.println("");

            } else if (selection == 2) {
                pObjects = Parser.getProductObjects(products);
                List<Product> sortedByName = sortProductsByName(pObjects); // izvikvame funkciq koqto sortirra obektite po ime
                for (Product p : sortedByName) {
                    System.out.println(p);

                }
                System.out.println("");
            } else if (selection == 3) {
                pObjects = Parser.getProductObjects(products);
                List<Product> sortedByPrice = sortProductsByPrice(pObjects);
                for (Product p : sortedByPrice) {
                    System.out.println(p);

                }
            } else if (selection == 4) {

                List<Product> sortedByDate = sortProductsByExpDate(products); // izvikvame funkciq koqto sortirra obektite po ime
                for (Product p : sortedByDate) {
                    System.out.println(p);

                }
                System.out.println("");
            } else if (selection == 5) {
                pObjects = Parser.getProductObjects(products);
                String pID = "0";
                Scanner input = new Scanner(System.in);

                System.out.println("Enter product ID: ");
                pID = input.nextLine();

                String pName = "0";


                System.out.println("Enter product name: ");
                pName = input.nextLine();

                System.out.println(getProductByNameAndID(Integer.parseInt(pID), pName, pObjects));
                System.out.println(" ");
            } else if (selection == 6) {
                pObjects = Parser.getProductObjects(products);
                String userChoice = "0";
                Scanner input = new Scanner(System.in);

                System.out.println("selection");
                userChoice = input.nextLine();

                try {
                    Integer.parseInt(userChoice);
                } catch (Exception e) {
                    System.out.println("Invalid input");
                    userChoice = "0";
                }
                int choice = Integer.parseInt(userChoice);
                for (Product p : pObjects) {
                    if (p.price >= choice) {
                        System.out.println(p);
                    }
                }
            } else if (selection == 7) {
                pObjects = Parser.getProductObjects(products);
                String userChoice = "0";
                Scanner input = new Scanner(System.in);

                System.out.println("selection");
                userChoice = input.nextLine();

                try {
                    Integer.parseInt(userChoice);
                } catch (Exception e) {
                    System.out.println("Invalid input");
                    userChoice = "0";
                }
                int choice = Integer.parseInt(userChoice);
                for (Product p : pObjects) {
                    if (p.price < choice) {
                        System.out.println(p);
                    }
                }
            } else if (selection == 8) {
                pObjects = Parser.getProductObjects(products);
                String userChoice = "0";
                Scanner input = new Scanner(System.in);

                System.out.println("selection");
                userChoice = input.nextLine();

                try {
                    Integer.parseInt(userChoice);
                } catch (Exception e) {
                    System.out.println("Invalid input");
                    userChoice = "0";
                }
                int choice = Integer.parseInt(userChoice);
                for (Product p : pObjects) {
                    if (p.getQuantity() >= choice) {
                        System.out.println(p);
                    }
                }
            } else if (selection == 9) {
                pObjects = Parser.getProductObjects(products);
                String userChoice = "0";
                Scanner input = new Scanner(System.in);

                System.out.println("selection");
                userChoice = input.nextLine();

                try {
                    Integer.parseInt(userChoice);
                } catch (Exception e) {
                    System.out.println("Invalid input");
                    userChoice = "0";
                }
                int choice = Integer.parseInt(userChoice);
                for (Product p : pObjects) {
                    if (p.getQuantity() < choice) {
                        System.out.println(p);
                    }
                }
            } else if (selection == 10) { // dobavqme el kum hashtabala i kum lista  producti
                String pID = "0";
                String pName = "";
                String pQuantity = "0";
                String pType = "0";
                String pPrice = "0";
                String pColor = "";
                String pDate = "";

                Scanner input = new Scanner(System.in);

                System.out.println("Enter ID: ");
                pID = input.nextLine();

                System.out.println(" Enter name: ");
                pName = input.nextLine();

                System.out.println("Enter quantity: ");
                pQuantity = input.nextLine();

                System.out.println("Enter type: ");
                pType = input.nextLine();

                System.out.println("Enter price: ");
                pPrice = input.nextLine();

                if (pType.equalsIgnoreCase("Food") || pType.equalsIgnoreCase("Drink") || pType.equalsIgnoreCase("Makeup")) {
                    System.out.println("Enter expireDate: ");
                    pDate = input.nextLine();
                }
                if (pType.equalsIgnoreCase("Other") || pType.equalsIgnoreCase("Makeup")) {
                    System.out.println("Enter Color: ");
                    pColor = input.nextLine();
                }
                if (pType.equalsIgnoreCase("food")) {
                    Hashtable<String, String> ba = new Hashtable<String, String>();
                    ba.put("name", pName);
                    ba.put("price", pPrice);
                    ba.put("quantity", pQuantity);
                    ba.put("type", pType);
                    ba.put("expiredate", pDate);
                    products.put(Integer.parseInt(pID), ba);
                } else if (pType.equalsIgnoreCase("drink")) {
                    Hashtable<String, String> ba = new Hashtable<String, String>();
                    ba.put("name", pName);
                    ba.put("price", pPrice);
                    ba.put("quantity", pQuantity);
                    ba.put("type", pType);
                    ba.put("expiredate", pDate);
                    products.put(Integer.parseInt(pID), ba);
                } else if (pType.equalsIgnoreCase("makeup")) {
                    Hashtable<String, String> ba = new Hashtable<String, String>();
                    ba.put("name", pName);
                    ba.put("price", pPrice);
                    ba.put("quantity", pQuantity);
                    ba.put("type", pType);
                    ba.put("expiredate", pDate);
                    ba.put("color", pColor);
                    products.put(Integer.parseInt(pID), ba);
                } else if (pType.equalsIgnoreCase("sanitary")) {
                    Hashtable<String, String> ba = new Hashtable<String, String>();
                    ba.put("name", pName);
                    ba.put("price", pPrice);
                    ba.put("quantity", pQuantity);
                    ba.put("type", pType);
                    products.put(Integer.parseInt(pID), ba);
                } else if (pType.equalsIgnoreCase("other")) {
                    Hashtable<String, String> ba = new Hashtable<String, String>();
                    ba.put("name", pName);
                    ba.put("price", pPrice);
                    ba.put("quantity", pQuantity);
                    ba.put("type", pType);
                    ba.put("color", pColor);
                    products.put(Integer.parseInt(pID), ba);
                }
            } else if (selection == 14) {
                System.out.println("Enter product ID: ");
                Scanner input = new Scanner(System.in);
                String pID = "";
                pID = input.nextLine();
                products.remove(Integer.parseInt(pID));


            } else if (selection == 15) {
                List<Employee> sortedByName = sortEmployeesByName(pEmployees); // izvikvame funkciq koqto sortirra obektite po ime
                for (Employee p : sortedByName) {
                    System.out.println(p);
                }
                System.out.println(sortedByName.size());
            } else if (selection == 16) {
                List<Employee> sortedBySalary = sortEmployeesBySalary(pEmployees);
                for (Employee p : sortedBySalary) {
                    System.out.println(p);

                }
            }else if (selection == 99) {

                    PrintWriter printWriter = new PrintWriter(System.currentTimeMillis()+ ".csv");

                    printWriter.print("id,name,price,quantity,type,color,expiration_date");
                    printWriter.printf("Product name is %s and its price is %d $", "iPhone", 1000);
                    printWriter.close();
            }

        }
    }

    public static int employeeWork() {
        System.out.println("Choose option: ");
        System.out.println("1-print all products");
        System.out.println("2-print all products sorted by name");
        System.out.println("3-print all products sorted by price");
        System.out.println("4-print all products sorted by expiration date");
        System.out.println("5-get specific product by ID and name");
        System.out.println("6-print all products above or equal to certain price");
        System.out.println("7-print all products below certain price");
        System.out.println("8-print all products above or equal to certain quantity");
        System.out.println("9-print all products below certain quantity");
        System.out.println("10-add new product");
        System.out.println("11-get product by ID and change price");
        System.out.println("12-get product by ID and change quantity");
        System.out.println("13-get product by ID and change name");
        System.out.println("14-delete product by ID");
        System.out.println("15-print employees sorted by name");
        System.out.println("16-print employee sorted by salary");
        System.out.println("99-save");
        System.out.println("100-exit program");

        String userChoice = "0";
        Scanner input = new Scanner(System.in);
        while ((Integer.parseInt(userChoice) < 1 || Integer.parseInt(userChoice) > 16)) {
            System.out.println("selection");
            userChoice = input.nextLine();

            try {
                Integer.parseInt(userChoice);
            } catch (Exception e) {
                System.out.println("Invalid input");
                userChoice = "0";
            }

        }
        return Integer.parseInt(userChoice);
    }

}
