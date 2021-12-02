public class Employee {


    private int id;
    private String name;
    private String lastname;
    private int salary;
    private int age;


    public Employee(int id, String name, String lastname, int age, int salary) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID='" + id + '\'' +
                "name='" + name + '\'' +
                "lastname='" + lastname + '\'' +
                "age='" + age + '\'' +
                "salary='" + salary + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}

