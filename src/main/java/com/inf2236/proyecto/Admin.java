package com.inf2236.proyecto;

import java.util.ArrayList;
import java.util.Date;

public class Admin extends User {
    static ArrayList<User> userList = new ArrayList<User>();

    public Admin(String nickName, String pasword, String email, Date birthDate) {
        super(nickName, pasword, email, birthDate);
    }

    @Override
    public void printUser() {
	System.out.println("ERES UN ADMINISTRADOR.\n\nNombre: " + nickName + "\nEmail: " + email + 
			   "\nFecha de nacimiento: " + birthDate + "\nPuntos: " + points + 
			   "\nAhorro de CO2: " + CO2Savings);
    }
}
