package main.java.ru.zateev.hibernate_test.entity.bi_directional_one_to_one;



import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {



    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "department")
    private String department;
    @Column(name = "salary")
    private int salary;
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    /**
     * Отношение один к одному - когда один объект знает о другом, а другой нет
     * cascade связывает любые изменения в данной талице с другой автоматически, а тип каскада -
     * это какие операции будут с этим связаны
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id") // говорится, что в данной таблице есть стобец details_id - внешний ключ
    private Details empDetails;

    public Employee() {
    }

    public Employee(String name, String surname, String department, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                '}';
    }


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Details getEmpDetails() {
        return empDetails;
    }

    public void setEmpDetails(Details empDetails) {
        this.empDetails = empDetails;
    }
}
