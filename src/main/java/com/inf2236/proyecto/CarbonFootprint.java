package com.inf2236.proyecto;

import java.util.Scanner;
import java.lang.Integer;
import java.lang.Float;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CarbonFootprint {
    private float home;
    private float transport;
    private float feeding;
    private float lifeStyle;

    public CarbonFootprint() {
	this.home      = 0.0F;
        this.transport = 0.0F;
        this.feeding   = 0.0F;
        this.lifeStyle = 0.0F;
    }

    private float calculateFootprintForCategory(BufferedReader fileBuffer) throws IOException {
	float result = 0;

	Scanner input = new Scanner(System.in);

        String splitedString[] = new String[12];
	String line;

        splitedString = fileBuffer.readLine().split(";");

        System.out.print("\033[H\033[2J");

        System.out.println(splitedString[1] + "\n");
        System.out.println(splitedString[2] + "\n");

	System.out.print("Presione Enter ");
	String garbage = input.nextLine();

	int questionCount = Integer.parseInt(splitedString[0]);

	for (int questionIndex = 0; 
	    questionIndex < questionCount && (line = fileBuffer.readLine()) != null; 
	    questionIndex++) 
	{
            splitedString = line.split(";");

            System.out.print("\033[H\033[2J");
            System.out.println(splitedString[1] + "\n");
	    if (!splitedString[2].equals(" ")) {
                System.out.println(splitedString[2] + "\n");
	    }

	    int optionCount = Integer.parseInt(splitedString[0]);
            splitedString = fileBuffer.readLine().split(";");

            int optionIndex = 0; 
	    while (optionIndex < optionCount) {
                System.out.println(optionIndex + ". " + splitedString[optionIndex * 2]);
                optionIndex++;
	    }

	    System.out.print("Respuesta: ");
	    int carbonFootprintIndex = (input.nextInt() * 2) + 1;
	    System.out.print("\n");

	    if (carbonFootprintIndex < optionCount) {
	        result += Float.parseFloat(splitedString[carbonFootprintIndex]);
	    }
	}

	return result;
    }

    public void questionnaireInicialization(String fileName) {
	try {
            BufferedReader fileBuffer = new BufferedReader(new FileReader(fileName));
            this.home = calculateFootprintForCategory(fileBuffer);
            this.transport = calculateFootprintForCategory(fileBuffer);
            this.feeding = calculateFootprintForCategory(fileBuffer);
            this.lifeStyle = calculateFootprintForCategory(fileBuffer);
	} catch (FileNotFoundException exception) {
	} catch (IOException exception) {
	}
    }

    public void printCarbonFootprint() {
	System.out.println("Hogar: " + this.home + "\nTrasporte: " + this.transport + 
                           "\nAlimentacion: " + this.feeding + "\nEstilo de vida: " + 
			    this.lifeStyle);
    }

    public boolean isInitialized() {
	boolean isInitialized = this.home != 0.0F && this.transport != 0.0F && 
	                        this.feeding != 0.0F && this.lifeStyle != 0.0F;
	return isInitialized;
    }

    public void setHome(float home) {
        this.home = home;
    }
    
    public float getHome() {
        return this.home;
    }

    public void setTransport(float transport) {
        this.transport = transport;
    }
    
    public float getTransport() {
        return this.transport;
    }

    public void setFeeding(float feeding) {
        this.feeding = feeding;
    }
    
    public float getFeeding() {
        return this.feeding;
    }

    public void setLifeStyle(float lifeStyle) {
        this.lifeStyle = lifeStyle;
    }
    
    public float getLifeStyle() {
        return this.lifeStyle;
    }
}
