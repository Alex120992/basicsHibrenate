package main.java.ru.zateev.hibernate_test.entity.uni_many_to_one;


import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {


    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "salary")
    private int salary;

    /** Много работников могут работать в одном департаменте
     * внешний ключ находится в той таблице, которая является Many(Employee)*/


    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;


    public Employee() {
    }

    public Employee(String name, String surname, int salary) {
        this.name = name;
        this.surname = surname;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }
}
