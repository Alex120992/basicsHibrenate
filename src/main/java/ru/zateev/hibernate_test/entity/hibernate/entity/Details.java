package main.java.ru.zateev.hibernate_test.entity.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "details")
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "city")
    private String city;
    @Column(name = "phone_number")
    private String phone_number;
    @Column(name = "mail")
    private String mail;


    public Details() {
    }

    public Details(String city, String phone_number, String mail) {

        this.city = city;
        this.phone_number = phone_number;
        this.mail = mail;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Details{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
