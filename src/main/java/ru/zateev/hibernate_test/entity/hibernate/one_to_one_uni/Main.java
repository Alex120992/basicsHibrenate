package main.java.ru.zateev.hibernate_test.entity.hibernate.one_to_one_uni;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Details.class)
                .buildSessionFactory();
        Session session = null;
        try {
             session = sessionFactory.getCurrentSession();

            /**
             *  Детали работника благодаря каскаду автоматически сохранятся в таблице details
             *  uni-directional
             */
//            Employee emp = new Employee("Oleg", "Smirnov", "Sal", 1000);
//            Details details = new Details("Moscow", "8495", "@mosc.ru");
//            emp.setEmpDetails(details);

            /** Выведем детали  работника*/
            session.beginTransaction();
            Employee emp = session.get(Employee.class,21);


            session.getTransaction().commit();
            System.out.println(emp.getEmpDetails());

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
