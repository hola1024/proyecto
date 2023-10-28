package com.inf2236.proyecto;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;

public class User {
    private String nickName;
    private String identifier;
    private String email;
    private Date birthDate;
    private int points;
    private float CO2Savings;
    private CarbonFootprint carbonFootprint;
    private ArrayList<Habit> habits = new ArrayList<Habit>();

    public User() {
        this.nickName = "";
        this.identifier = "";
        this.email = "";
        this.birthDate = new Date();
	this.points = 0;
	this.CO2Savings = 0.0F;
	this.carbonFootprint = new CarbonFootprint();
    }
    
    public User(String nickName, String identifier, String email, Date birthDate, 
		int points, float CO2Savings, CarbonFootprint carbonFootprint) {
        this.nickName = nickName;
        this.identifier = identifier;
        this.email = email;
        this.birthDate = birthDate;
	this.points = points;
	this.CO2Savings = CO2Savings;
	this.carbonFootprint = carbonFootprint;
    }

    public void printUser() {
	System.out.println("Nombre: " + nickName + "\nRut: " + identifier + "\nEmail: " + email + 
			   "\nFecha de nacimiento: " + birthDate + "\nPuntos: " + points + 
			   "\nAhorro de CO2: " + CO2Savings);
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    public String getNickName() {
        return this.nickName;
    }
    
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    
    public String getIdentifier() {
        return this.identifier;
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
