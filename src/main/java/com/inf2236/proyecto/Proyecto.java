//umletino

package com.inf2236.proyecto;

import UI.frame;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.text.ParseException;

public class Proyecto {
    public static ArrayList<Habit> globalHabitList = new ArrayList<Habit>();

    public static int inputInteger() {
	Scanner input = new Scanner(System.in);
	int option = 0;

	try { 
	    option = input.nextInt();
	} catch (InputMismatchException exception) {
	    String garbage = input.nextLine();
	    option = -1;
	}

	return option;
    }

    public static void habitsMenu(User user) {
	Scanner input = new Scanner(System.in);

	boolean exit = false;

	System.out.print("\n");

	do {
            System.out.print("\033[H\033[2J");

	    ArrayList<Habit> habits = user.getHabits();
	    Habit.printHabits(habits);
	    System.out.println("Elija una opcion:");
	    System.out.println("0: Atras.");
	    System.out.println("1: Ver todos los habitos.");
	    System.out.println("2: Agregar un nuevo habito.");
	    System.out.print("Tu opcion: ");

	    int option = inputInteger();

	    switch (option) {
		case 0: {
		    exit = true;
		} break;

		case 1: {
	            System.out.print("\n");
                    System.out.print("\033[H\033[2J");

	            Habit.printHabits(globalHabitList);

	            System.out.print("Presione Enter ");

	            String garbage = input.nextLine();
		} break;

		case 2: {
	            System.out.print("\nIngrese el id del nuevo habito: ");
	            int habitId = inputInteger();
	            System.out.print("\n");

		    Habit habit = Habit.getHabitByIdInArray(globalHabitList, habitId);

		    if (habit != null) {
			user.setHabits(Habit.addHabitToArray(user.getHabits(), habit));
		    }
		} break;
	    }

	} while (!exit);
    }

    public static void footprintMenu(User user) {
	Scanner input = new Scanner(System.in);

	while (!user.getCarbonFootprint().isInitialized()) {
	    System.out.print("\n");
            System.out.print("\033[H\033[2J");

	    System.out.println("Todavia no has realizado la encuesta de " + 
			       "inicializacion. Deseas realizarla?");
	    System.out.println("0: No y regresar.");
	    System.out.println("1: Si.");
	    System.out.print("Tu opcion: ");

	    int option = inputInteger();

	    switch (option) {
		case 0: {
		    return;
		}

		case 1: {
		    CarbonFootprint initializedFootprint = new CarbonFootprint();
		    initializedFootprint.questionnaireInicialization("questionnaire.txt");
		    user.setCarbonFootprint(initializedFootprint);
		} break;
	    }

	} 

        System.out.print("\033[H\033[2J");
	user.getCarbonFootprint().printCarbonFootprint();

	System.out.print("\nPresione Enter ");

	String garbage;
	garbage = input.nextLine();
    }

    public static void userMenu() {
	UserHandler userHandler = new UserHandler();
	Scanner input = new Scanner(System.in);

	boolean exit = false;

	do {
	    System.out.print("\n");
            System.out.print("\033[H\033[2J");

	    System.out.println("Elija una opcion:");
	    System.out.println("0: Salir de la cuenta.");
	    System.out.println("1: Ver perfil");
	    System.out.println("2: Ver tu huella de carbono.");
	    System.out.println("3: Ver tus habitos.");
	    System.out.println("4: Eliminar la cuenta.");
	    System.out.print("Tu opcion: ");

	    int option = inputInteger();

	    switch (option) {
		case 0: {
		    exit = true;
		} break;

		case 1: {
                    System.out.print("\033[H\033[2J");
		    user.printUser();

	            System.out.print("\nPresione Enter ");
	            String garbage = input.nextLine();
		} break;

		case 2: {
                    footprintMenu(user);
		} break;

		case 3: {
		    habitsMenu(user);
		} break;

		case 4: {
	            System.out.println("Ingrese la palabra CONFIRMAR si esta seguro de " +
				       "eliminar su cuenta.");

		    String confirmation = input.nextLine();

		    if (confirmation.equals("CONFIRMAR")) {
                        userHandler.deleteAccount(user);
			exit = true;
		    }
		} break;
	    }

	} while (!exit);
    }

    public static void main(String[] args) {
	new frame().setVisible(true);
/*
	Scanner input = new Scanner(System.in);
	UserHandler userHandler = new UserHandler();
	User user = new User();

        Habit.loadHabitsFromFile(globalHabitList, "src/test/habits.csv");

        boolean exit = false;

	System.out.print("\n");

	do {
	    System.out.println("Elija una opcion:");
	    System.out.println("0: Cerrar el programa.");
	    System.out.println("1: Iniciar Sesion.");
	    System.out.println("2: Registrarse.");
	    System.out.print("Tu opcion: ");
	    
            int option = inputInteger();

	    switch (option) {
		case 0: {
		    exit = true;
		} break;

		case 1: {
	            System.out.print("\nIngrese su rut: ");
		    String nickName = input.nextLine();
		    user = userHandler.searchUser(nickName);

		    if (user != null) {
                        userMenu(userHandler, user);
		    } else {
	                System.out.println("\nNo se ha encontrado un usuario con el rut " + 
					   nickName);

	                System.out.print("\nPresione Enter ");
	                String garbage = input.nextLine();
		    }
		} break;

		case 2: {
                    System.out.print("\033[H\033[2J");

		    user = userHandler.createNewAccount();
                    userMenu(userHandler, user);
		} break;
	    }

            System.out.print("\033[H\033[2J");
	} while (!exit);
*/
    }
}
