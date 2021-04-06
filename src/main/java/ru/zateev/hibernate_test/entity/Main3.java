package main.java.ru.zateev.hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();
             /**
              * получение всех работников из БД*/
//            List <Employee> emps = session.createQuery("from Employee").getResultList();// указываем имя класса Employee

            /** Получение всех работников с именем Алексей*/
//            List <Employee> emps = session.createQuery("from Employee where  surname = 'Zateev'").getResultList();
            /** Получение всех работников с именем Алексей и с зарплатой больше 500*/
            List <Employee> emps = session
                    .createQuery("from Employee where  surname = 'Zateev' AND salary > 500")
                    .getResultList();

            for (Employee x : emps)
                System.out.println(x);

            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            sessionFactory.close();
        }
    }
}
