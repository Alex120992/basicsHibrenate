package main.java.ru.zateev.hibernate_test.entity.bi_direct_one_to_many;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try {
            /** Один департамент и много работников*/
//            session = sessionFactory.getCurrentSession();
//            Department dep = new Department("IT",1200,300);
//            Employee employee = new Employee("Aleksey","Zat", 500);
//            Employee employee2 = new Employee("Elena","Ivanova", 450);
//
//            dep.addEmployeeToDepartment(employee);
//            dep.addEmployeeToDepartment(employee2);
////
//            session.beginTransaction();
//            session.save(dep);
//
//
//            System.out.println("Done");
//
//            session.getTransaction().commit();
/** Получение департамента и его работников*/
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            Department dep = session.get(Department.class,3);
//
//
//            System.out.println(dep);
//            System.out.println(dep.getEmps());
//
//            session.getTransaction().commit();
            /** Удаление работка без удаления департамаента */
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 4);




            session.getTransaction().commit();


        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
