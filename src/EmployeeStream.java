import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee1 {
    public int id;
    public String name;
    private int sal;
    private double yearsInOrg;
    private String role;
    private String gender;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public double getYearsInOrg() {
        return yearsInOrg;
    }

    public void setYearsInOrg(double yearsInOrg) {
        this.yearsInOrg = yearsInOrg;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public Employee1(String name, int id, int sal, double years, String role, String gender) {
        this.id = id;
        this.name = name;
        this.sal = sal;
        this.yearsInOrg = years;
        this.role = role;
        this.gender = gender;
    }

    public static List<Employee1> getEmployeeList(){
        Employee1 e1 = new Employee1("Name1",101, 1000, 1, "SE", "M");
        Employee1 e2 = new Employee1("Name2",102, 2000, 1, "SSE", "M");
        Employee1 e3 = new Employee1("Name3",103, 3000, 3, "TA", "F");
        Employee1 e4 = new Employee1("Name4",104, 4000, 4, "TA", "M");
        Employee1 e5 = new Employee1("Name5",105, 5000, 5, "TL", "F");

        List<Employee1> emp = new ArrayList<>();
        emp.add(e1);
        emp.add(e2);
        emp.add(e3);
        emp.add(e4);
        emp.add(e5);

        return emp;
    }

    // Getters and setters
}

public class EmployeeStream {

    //a. Employees whose role is TA
    //b. Count of female employees
    public static void main(String[] args) {
        List<Employee1> allEmployees = Employee1.getEmployeeList();

        Stream<Employee1> empStream = allEmployees.stream();
        empStream.forEach((e) -> System.out.println(e.getId() + " : " +e.getName()));

        Stream<Employee1> filterStream = allEmployees.stream();
        filterStream.filter(e -> e.getRole() == "TA")
                .forEach(e -> System.out.println(e.getName()));

        Stream<Employee1> countStream = allEmployees.stream();
        long femaleEmployeeCount = countStream.filter(e -> e.getGender() == "F").count();
        System.out.println("Count of Female Employees: " + femaleEmployeeCount);

        // Increase the salary for employees with experience less than 1
        Stream<Employee1> updateStream = allEmployees.stream();

        List<Employee1> updatedEmployees = updateStream.filter(e -> e.getYearsInOrg() <= 1)
                .map( e -> {e.setSal(e.getSal() + 5000); return e;})
                .collect(Collectors.toList());

        updatedEmployees.forEach((e) -> System.out.println(e.getName() + ", " + e.getSal()));

        //Finding the maximum salary
        Optional<Integer> max = updatedEmployees.stream().map(emp -> emp.getSal())
                .reduce(Integer::max);

        List<Employee1> maxSalaryEmployee = updatedEmployees.stream()
                .filter(e -> e.getSal() == max.get())
                .collect(Collectors.toList());

        maxSalaryEmployee.forEach(e -> System.out.println(e.getName()));


    }


}
