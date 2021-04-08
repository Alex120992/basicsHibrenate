package main.java.ru.zateev.hibernate_test.entity.bi_direct_one_to_many;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "max_salary")
    private int max_salary;
    @Column(name = "min_salary")
    private int min_salary;
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.PERSIST,
            CascadeType.DETACH,CascadeType.MERGE}, mappedBy = "department")
    private List<Employee> emps;

    public Department() {
    }

    public Department(String name, int max_salary, int min_salary) {
        this.name = name;
        this.max_salary = max_salary;
        this.min_salary = min_salary;
    }

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

    public int getMax_salary() {
        return max_salary;
    }

    public void setMax_salary(int max_salary) {
        this.max_salary = max_salary;
    }

    public int getMin_salary() {
        return min_salary;
    }

    public void setMin_salary(int min_salary) {
        this.min_salary = min_salary;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }
    public void  addEmployeeToDepartment(Employee employee){
        if(emps == null){
            emps = new ArrayList<>();
        }
        emps.add(employee);
        employee.setDepartment(this);
    }
    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", max_salary='" + max_salary + '\'' +
                ", min_salary='" + min_salary + '\'' +
                '}';
    }
}
