package main.java.ru.zateev.hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main5 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            Employee emp = session.get(Employee.class, 19);
            /** Удаление работника*/

//            session.delete(emp);

            /** Удаление всех работников с именем Алексей*/
            session.createQuery("delete Employee where name = 'Aleksey'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            sessionFactory.close();
        }
    }
}
