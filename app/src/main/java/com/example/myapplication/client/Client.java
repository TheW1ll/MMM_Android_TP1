package com.example.myapplication.client;

public class Client {
    private String nom;
    private String prenom;
    private String birthplace;
    private String birthday;
    private String telephone;

    public Client(String nom) {
        this.nom = nom;
    }

    public Client(String nom, String prenom, String birthplace, String birthday, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.birthplace = birthplace;
        this.birthday = birthday;
        this.telephone = telephone;
    }

    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
