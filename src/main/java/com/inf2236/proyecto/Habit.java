package com.inf2236.proyecto;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.util.Scanner;
import java.lang.Float;
import java.lang.Integer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.util.ArrayList;

public class Habit {
    private int id;
    //Concienciado, comprometido, sostenible, the planet hero
    private String tier;
    private String category;
    private String title;
    private String description;
    private float CO2AnualImpact;

    public Habit() {
	this.id = -1;
	this.tier = "";
	this.category = category;
	this.title = "";
	this.description = "";
	this.CO2AnualImpact = 0.0F;
    }

    public Habit(int id, String tier, String category, String title, String description, 
		 float CO2AnualImpact) {
	this.id = id;
	this.tier = tier;
	this.category = category;
	this.title = title;
	this.description = description;
	this.CO2AnualImpact = CO2AnualImpact;
    }

    public static void loadHabitsFromFile(ArrayList<Habit> habitList, String fileName) {
	System.out.println("hola papus");

        try {
            FileReader file = new FileReader(fileName);

	    System.out.println("hola papus 2");

            CSVReader fileCSV = new CSVReader(file);
        
	    System.out.println("hola papus 3");

            String[] splitedString;
            
	    splitedString = fileCSV.readNext();

            while ((splitedString = fileCSV.readNext()) != null) {
		System.out.println("Pene");
                habitList.add(new Habit(Integer.parseInt(splitedString[0]), splitedString[1],
					splitedString[2], splitedString[3], splitedString[4],
					Float.parseFloat(splitedString[5])));
            }
	} catch (CsvValidationException | IOException exception) {
            System.out.println("Tenemos un problema papussss");
	}
    }

    public static void printHabits(ArrayList<Habit> habits) {
	for (int habitsIndex = 0; habitsIndex < habits.size(); habitsIndex++) {
	    Habit habit = habits.get(habitsIndex);
	    System.out.println("ID: " + habit.getId() + ", Nivel: " + habit.getTier() + ", Categoria: " + 
			       habit.getCategory() + ", Impacto CO2: " + habit.getCO2AnualImpact() + 
			       "\nHabito: " + habit.getTitle() + "\n\n" + habit.getDescription() + "\n");
	}
    }

    public static boolean isValidHabit(Habit habit) {
	return habit.getId() != -1;
    }

    public static Habit searchHabitById(ArrayList<Habit> habits, int id) {
	for (int habitIndex = 0; habitIndex < habits.size(); habitIndex++) {
	    Habit habit = habits.get(habitIndex);
	    if (habit.getId() == id) {
                return habit;
	    }
	}

        return new Habit();
    }

    public static ArrayList<Habit> addHabitToArray(ArrayList<Habit> habits, Habit habit) {
        Habit habitFind = Habit.searchHabitById(habits, habit.getId());
	if (!Habit.isValidHabit(habitFind)) {
            habits.add(habit);
	}
	
	return habits;
    }

    public static Habit getHabitByIdInArray(ArrayList<Habit> habits, int id) {
        Habit habit = Habit.searchHabitById(habits, id);
        return habit;
    }

    public static Habit getHabitByIndexInArray(ArrayList<Habit> habits, int index) {
	if (index < habits.size()) {
            return habits.get(index);
	}

        return new Habit();
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }
    
    public String getTier() {
        return this.tier;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getCategory() {
        return this.category;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return this.title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return this.description;
    }

    public void setCO2AnualImpact(float CO2AnualImpact) {
        this.CO2AnualImpact = CO2AnualImpact;
    }
    
    public float getCO2AnualImpact() {
        return this.CO2AnualImpact;
    }
}