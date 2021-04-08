package main.java.ru.zateev.hibernate_test.entity.uni_many_to_one;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
/** uni - one_to_many*/
        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try {

            session = sessionFactory.getCurrentSession();
            Department dep = new Department("Worker",900,450);
            Employee employee = new Employee("Olga","Sidorova", 980);
            Employee employee2 = new Employee("Oleg","Yazenov", 1100);

            dep.addEmployeeToDepartment(employee);
            dep.addEmployeeToDepartment(employee2);




            session.beginTransaction();
            session.save(dep);




            session.getTransaction().commit();


        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
