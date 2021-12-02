import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class Parser {

    public static List<Product> getProductObjects(Hashtable<Integer, Hashtable<String, String>> products) {
        List<Product> productObjects = new ArrayList<>();
        Enumeration<Integer> e = products.keys();

        while (e.hasMoreElements()) {
            int key = e.nextElement();


            if (products.get(key).get("type").equals("food")) {
                Hashtable<String, String> item = products.get(key);
                Food x = new Food(key, item.get("name"), Double.parseDouble(item.get("price")), Integer.parseInt(item.get("quantity")), item.get("expiredate"));
                productObjects.add(x);
            } else if (products.get(key).get("type").equals("drink")) {
                Hashtable<String, String> item = products.get(key);
                Drink x = new Drink(key, item.get("name"), Double.parseDouble(item.get("price")), Integer.parseInt(item.get("quantity")), item.get("expiredate"));
                productObjects.add(x);
            } else if (products.get(key).get("type").equals("sanitary")) {
                Hashtable<String, String> item = products.get(key);
                Sanitary x = new Sanitary(key, item.get("name"), Double.parseDouble(item.get("price")), Integer.parseInt(item.get("quantity")));
                productObjects.add(x);
            } else if (products.get(key).get("type").equals("makeup")) {
                Hashtable<String, String> item = products.get(key);
                Makeup x = new Makeup(key, item.get("name"), Double.parseDouble(item.get("price")), Integer.parseInt(item.get("quantity")), item.get("expiredate"), item.get("color"));
                productObjects.add(x);
            } else if (products.get(key).get("type").equals("other")) {
                Hashtable<String, String> item = products.get(key);
                Other x = new Other(key, item.get("name"), Double.parseDouble(item.get("price")), Integer.parseInt(item.get("quantity")), item.get("color"));
                productObjects.add(x);
            }
        }
        return productObjects;
    }

    public static List<Employee> getEmployeeObjects(Hashtable<Integer, Hashtable<String, String>> employees) {
        List<Employee> employeeObjects = new ArrayList<>();
        Enumeration<Integer> e = employees.keys();
        System.out.println(employees);
        while (e.hasMoreElements()) {
            int key = e.nextElement();


            Hashtable<String, String> item = employees.get(key);
            Employee x = new Employee(key, item.get("name"), item.get("lastname"), Integer.parseInt(item.get("age")), Integer.parseInt(item.get("salary")));
            employeeObjects.add(x);

        }
        return employeeObjects;
    }

    public static Hashtable<Integer, Hashtable<String, String>> getProductsList(BufferedReader products) throws IOException {
        String line = products.readLine();
        Hashtable<Integer, Hashtable<String, String>> parsedProducts = new Hashtable<Integer, Hashtable<String, String>>();
        while ((line = products.readLine()) != null) {
            String[] b = line.split(",");

            Hashtable<String, String> productData = new Hashtable<String, String>();
            if (b.length >= 7) {
                productData.put("expiredate", b[6]);
            }
            if (b.length >= 6) {
                productData.put("color", b[5]);
            }
            productData.put("type", b[4]);
            productData.put("quantity", b[3]);
            productData.put("price", b[2]);
            productData.put("name", b[1]);

            parsedProducts.put(Integer.parseInt(b[0]), productData);
        }
        //products.close();
        return parsedProducts;
    }

    public static Hashtable<Integer, Hashtable<String, String>> getEmployeesList(BufferedReader employees) throws IOException {
        String line = employees.readLine();
        Hashtable<Integer, Hashtable<String, String>> parsedEmployees = new Hashtable<Integer, Hashtable<String, String>>();
        while ((line = employees.readLine()) != null) {
            String[] b = line.split(",");

            Hashtable<String, String> employeeData = new Hashtable<String, String>();

            employeeData.put("salary", b[4]);
            employeeData.put("age", b[3]);
            employeeData.put("lastname", b[2]);
            employeeData.put("name", b[1]);

            parsedEmployees.put(Integer.parseInt(b[0]), employeeData);
        }
//        employees.close();
        return parsedEmployees;
    }

    public static Hashtable<Integer, String> csvParser(Hashtable<Integer, Hashtable<String, String>> file) throws IOException {

        Hashtable<Integer, String> employees = new Hashtable<Integer, String>();

        System.out.println(file);
        Enumeration<Integer> e = file.keys();

        while (e.hasMoreElements()) {
            int key = e.nextElement();


            Hashtable<String, String> item = file.get(key);

            employees.put(key, item.get("name"));

        }
        // file.close();
        System.out.println(employees);
        return employees;

    }


}
