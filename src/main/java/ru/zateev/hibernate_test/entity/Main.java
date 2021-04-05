package main.java.ru.zateev.hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        /**
         * Sessionfactory - фабрика по производству сессий
         * она считывает xml файл после этого она знает как должны создаваться сессии
         * addAnnotatedClass - считываем данный класс с аннотациями
         * buildSessionFactory - строим данный объект*/
        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
/** Обертка для подключения к базе с помощью jdbc
 * через нее работаем с классом Employee*/
        try {
            Session session = sessionFactory.getCurrentSession();
            Employee emp;

            emp = new Employee("Aleksey", "Zateev", "IT", 1000 );


            /*открываем транзакции вручную*/
            session.beginTransaction();
            /* Сохраняем объект insert*/
//            session.save(emp);
            session.save(emp);
            //закрытие транзакции
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
