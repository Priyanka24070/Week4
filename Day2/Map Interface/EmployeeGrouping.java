import java.util.*;
import java.util.stream.*;

class Employee {
    String name;
    Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return name;
    }
}

enum Department {
    HR, IT, SALES, FINANCE;
}

public class EmployeeGrouping {

    public static void main(String[] args) {
        // List of employees
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", Department.HR),
            new Employee("Bob", Department.IT),
            new Employee("Carol", Department.HR)
        );

        // Group employees by department
        Map<Department, List<Employee>> groupedByDepartment = groupEmployeesByDepartment(employees);

        // Print the grouped employees
        groupedByDepartment.forEach((department, employeeList) -> {
            System.out.println(department + ": " + employeeList);
        });
    }

    // Function to group employees by their department
    public static Map<Department, List<Employee>> groupEmployeesByDepartment(List<Employee> employees) {
        return employees.stream()
                        .collect(Collectors.groupingBy(employee -> employee.department));
    }
}
