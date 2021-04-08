package main.java.ru.zateev.hibernate_test.entity.bi_directional_one_to_one;


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
//            Employee employee = new Employee("Nikolay", "Smirnow", "Sales", 800);
//            Details empDetails = new Details("Moscow", "124342", "Nik@mail.com");
//            /** Используем две сеттера для bi-directional*/
//            employee.setEmpDetails(empDetails);
//            empDetails.setEmployee(employee);
            session.beginTransaction();
            Details details = session.get(Details.class, 1);
            /** Сначала разрушаем связь между работником и деталями, чтобы разрушить связть*/
            details.getEmployee().setEmpDetails(null);
            session.delete(details);




            session.getTransaction().commit();


        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
