package com.example.MoneyReminder;

import javax.persistence.*;

@Entity
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String name;
    @Column
    String email;
    @Column
    int owes;


    public Friend (String name, String email) {
        this.name = name;
        this.email = email;

    }

    public Friend() {

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getOwes() {
        return owes;
    }
    public void setOwes(int id) {
        this.owes = owes;
    }
}
