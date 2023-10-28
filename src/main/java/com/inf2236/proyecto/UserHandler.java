package com.inf2236.proyecto;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;

public class UserHandler {
    private ArrayList<User> userList = new ArrayList<User>();

    public User createNewAccount() {
	User newUser = new User();
	
	Scanner input = new Scanner(System.in);

	System.out.print("Ingrese su nombre de etiqueta: ");
        String nickName = input.nextLine();
	System.out.print("\nIngrese su rut: ");
        String identifier = input.nextLine();
	System.out.print("\nIngrese su email: ");
        String email = input.nextLine();

	boolean dataIsWrong;

        Date birthDate = new Date();

	do {
            dataIsWrong = false;

	    try {
	        System.out.print("\nIngrese su fecha de nacimiento [dia/mes/año]: ");
	        String dateStr = input.nextLine();
                birthDate = new SimpleDateFormat("dd/mm/yyyy").parse(dateStr);
	    } catch (ParseException exception) {
	        System.out.print("\nIngreso su fecha de nacimiento en un formato incorrecto.\n");
                dataIsWrong = true;
	    }

        } while (dataIsWrong);

        int points = 0;
        float CO2Savings = 0.0F;
        CarbonFootprint carbonFootprint = new CarbonFootprint();

        newUser = new User(nickName, identifier, email, birthDate, points, CO2Savings, 
			   carbonFootprint);

        userList.add(newUser);

	return newUser;
    }

    public User searchUser(String identifier) {
	for (int userIndex = 0; userIndex < userList.size(); userIndex++) {
	    User user = userList.get(userIndex);

	    if (user.getIdentifier().equals(identifier)) {
	        return user;
	    }
	}

	return null;
    }

    public void deleteAccount(User user) {
	userList.remove(user);
    }
}
