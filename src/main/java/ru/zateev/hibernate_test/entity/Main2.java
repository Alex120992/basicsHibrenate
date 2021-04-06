package main.java.ru.zateev.hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            Employee emp;

            emp = new Employee("Aleksey", "Zat", "IT's", 100);


            /*открываем транзакции вручную*/
            session.beginTransaction();
            /* Сохраняем объект insert*/
//            session.save(emp);
            session.save(emp);
            //закрытие транзакции
            session.getTransaction().commit();

            /**
             * получение текущего id и объекта по id
             * Все это можно делать из одной транзакции*/
            int id = emp.getId();

            System.out.println(id);

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, id);
            session.getTransaction().commit();
            System.out.println(employee);


        } finally {
            sessionFactory.close();
        }
    }
}
