import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
               "name='" + name + '\'' +
               ", id=" + id +
               ", salary=" + salary +
               '}';
    }
}

public class EmployeeManagementSystem {
    private ArrayList<Employee> employees = new ArrayList<>();

    public void addEmployee(String name, int id, double salary) {
        Employee employee = new Employee(name, id, salary);
        employees.add(employee);
    }

    public Employee findEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void displayAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        boolean running = true;

        while (running) {
            System.out.println("Employee Management System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Find Employee by ID");
            System.out.println("3. Display All Employees");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Employee Salary: ");
                    double salary = scanner.nextDouble();
                    ems.addEmployee(name, id, salary);
                    System.out.println("Employee added.");
                    break;

                case 2:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = scanner.nextInt();
                    Employee foundEmployee = ems.findEmployee(searchId);
                    if (foundEmployee != null) {
                        System.out.println("Employee Found: " + foundEmployee);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 3:
                    System.out.println("All Employees:");
                    ems.displayAllEmployees();
                    break;

                case 4:
                    System.out.println("Exiting Employee Management System.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
