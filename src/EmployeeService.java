import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Employee{
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearsInOrg() {
        return yearsInOrg;
    }

    public void setYearsInOrg(Integer yearsInOrg) {
        this.yearsInOrg = yearsInOrg;
    }

    public Employee(Integer id, String name, Integer yearsInOrg) {
        this.id = id;
        this.name = name;
        this.yearsInOrg = yearsInOrg;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", yearsInOrg=" + yearsInOrg + ", name=" + name + "]";
    }

    private Integer id;
    private String name;
    private Integer yearsInOrg;

    public static List<Employee> getEmployeeList(){
        Employee e1 = new Employee(101, "Roger",0);
        Employee e2 = new Employee(102, "Chris", 1);
        Employee e3 = new Employee(103,"Samuel",0);
        Employee e4 = new Employee(102,"Brian",3);

        List<Employee> empList = new ArrayList<>();
        empList.add(e1);
        empList.add(e2);
        empList.add(e3);
        empList.add(e4);

        return empList;
    }

}

public class EmployeeService {
    public static void main(String[] args) {
        // Printing the Stream
        List<Employee> FirstEmp = Employee.getEmployeeList();
        Stream<Employee> empStream = FirstEmp.stream();
        empStream.forEach(System.out::println);

        //Filtering the Stream
        Stream<Employee> filterStream = FirstEmp.stream();
        Stream<Employee> filter_emp_stream = filterStream.filter(employee -> employee.getYearsInOrg()<1);
        filter_emp_stream.forEach(System.out::println);

        //Sorting the Stream
        Stream<Employee> sortedStream = FirstEmp.stream();
        Stream<Employee> sortedEmpStream = sortedStream.sorted((e1, e2) -> e1.getId() - e2.getId());
        sortedEmpStream.forEach(System.out::println);

        //Pipleling all functionalities to a single stream
        Stream<Employee> pipleLineStream = FirstEmp.stream();
        pipleLineStream.filter(employee -> employee.getYearsInOrg()<1)
                .sorted((e1,e2) -> e1.getId() - e2.getId())
                .forEach((e) -> System.out.println(e.getId() + ":" + e.getName()));
        //        .forEach(System.out::print);

    }
}
