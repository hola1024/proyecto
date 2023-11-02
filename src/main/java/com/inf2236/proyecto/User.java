package com.inf2236.proyecto;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;

public class User {
    protected String nickName;
    protected String pasword;
    protected String email;
    protected Date birthDate;
    protected int points;
    protected float CO2Savings;
    protected CarbonFootprint carbonFootprint;
    protected ArrayList<Habit> habits = new ArrayList<Habit>();

    public User() {
        this.nickName = "";
        this.pasword = "";
        this.email = "";
        this.birthDate = new Date();
	this.points = 0;
	this.CO2Savings = 0.0F;
	this.carbonFootprint = new CarbonFootprint();
    }
    
    public User(String nickName, String pasword, String email, Date birthDate) {
        this.nickName = nickName;
        this.pasword = pasword;
        this.email = email;
        this.birthDate = birthDate;
	this.points = 0;
	this.CO2Savings = 0.0F;
	this.carbonFootprint = null;
    }

    public void printUser() {
	System.out.println("Nombre: " + nickName + "\nEmail: " + email + "\nFecha de nacimiento: " + 
			   birthDate + "\nPuntos: " + points + "\nAhorro de CO2: " + CO2Savings);
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    public String getNickName() {
        return this.nickName;
    }
    
    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
    
    public String getPasword() {
        return this.pasword;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setBirthDate(String birthDate) throws ParseException {
        Date date = new SimpleDateFormat("dd/mm/yyyy").parse(birthDate);
        this.birthDate = date;
    }
    
    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setCarbonFootprint(CarbonFootprint carbonFootprint) {
        this.carbonFootprint = carbonFootprint;
    }

    public CarbonFootprint getCarbonFootprint() {
        return this.carbonFootprint;
    }

    public void setHabits(ArrayList<Habit> habits) {
        this.habits = habits;
    }

    public ArrayList<Habit> getHabits() {
        return this.habits;
    }
}
