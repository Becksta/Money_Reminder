package com.example.MoneyReminder;

public class Friend {
    String name;
    String email;
    String id;
    int owes;
    private Controller MoneyReminder;

    public Friend (String name, String email, String id) {
        this.name = name;
        this.email = email;
        this.id = id;

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
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getOwes() {
        return owes;
    }
    public void setOwes(int id) {
        this.owes = owes;
    }
}
