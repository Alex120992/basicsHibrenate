package main.java.ru.zateev.hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main4 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();
/** Изменение фамилии и зарплаты в БД*/
//            Employee emp = session.get(Employee.class, 10);
//            emp.setSurname("Vaganov");
//            emp.setSalary(250);
/** Изменим всем зарплату у кого имя Алексей */
            session.createQuery("update Employee set salary = 1000" +
                    " where name = 'Aleksey'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            sessionFactory.close();
        }
    }
}
