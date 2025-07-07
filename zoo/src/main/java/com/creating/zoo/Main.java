package com.creating.zoo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.creating.zoo.animalType.Animal;
import com.creating.zoo.animalType.Dolphin;
import com.creating.zoo.animalType.Penguin;
import com.creating.zoo.animalType.Tiger;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int continueOuterLoop;
        int continueInnerLoop;

        int menuChoice;

        Tiger tigerObject = new Tiger();
        Dolphin dolphinObject = new Dolphin();
        Penguin penguinObject = new Penguin();

        do { 
            switch (animalChoiceMenu(keyboard)) {
                case 1:
                    do { 
                        System.out.println("The animal which is chosen is: " +
                                            tigerObject.getNameOfAnimal());
                        menuChoice = animalDetailsManipulationMenu(keyboard, tigerObject);

                        switch (menuChoice) {
                            case 1:
                                tigerObject.setProperties(keyboard);
                                break;
                            case 2:
                                tigerObject.displayProperties();
                                break;
                            case 3:
                                tigerObject.walking();
                                break;
                            case 4:
                                tigerObject.eatingCompleted();
                                break;
                            default:
                                System.out.println("Not supported.");
                        }
                        System.out.println("Continue with this animal ? (Enter 1 for yes/ 2 for no):");
                        continueInnerLoop = keyboard.nextInt();
                    } while ( continueInnerLoop == 1);
                    break;

                case 2:
                    do { 
                        System.out.println("The animal which is chosen is: " +
                                            dolphinObject.getNameOfAnimal());
                        menuChoice = animalDetailsManipulationMenu(keyboard, dolphinObject);

                        switch (menuChoice) {
                            case 1:
                                dolphinObject.setProperties(keyboard);
                                break;
                            case 2:
                                dolphinObject.displayProperties();
                                break;
                            case 3:
                                dolphinObject.swimming();
                                break;
                            case 4:
                                dolphinObject.eatingCompleted();
                                break;
                            default:
                                System.out.println("Not supported.");
                        }
                        System.out.println("Continue with this animal ? (Enter 1 for yes/ 2 for no):");
                        continueInnerLoop = keyboard.nextInt();
                    } while ( continueInnerLoop == 1);
                    break;

                case 3:
                    do { 
                        System.out.println("The animal which is chosen is: " +
                                            penguinObject.getNameOfAnimal());
                        menuChoice = animalDetailsManipulationMenu(keyboard, penguinObject);

                        switch (menuChoice) {
                            case 1:
                                System.out.println(penguinObject.getNameOfAnimal() +
                                                    ": Is swimming? (Y/N)");
                                String penguinSwimmingTrue = keyboard.next()
                                                    .toLowerCase();
                                penguinObject.setSwimming(penguinSwimmingTrue.equals("y"));

                                penguinObject.setProperties(keyboard);
                                break;
                            case 2:
                                penguinObject.displayProperties();
                                break;
                            case 3:
                                if(penguinObject.isIsSwimming()){
                                    penguinObject.swimming();
                                } else {
                                    penguinObject.walking();
                                }
                                break;
                            case 4:
                                penguinObject.eatingCompleted();
                                break;
                            default:
                                System.out.println("Not supported.");
                        }
                        System.out.println("Continue with this animal ? (Enter 1 for yes/ 2 for no):");
                        continueInnerLoop = keyboard.nextInt();
                    } while ( continueInnerLoop == 1);
                    break;
                case 4:
                    writeObjectsToFile(tigerObject, penguinObject, dolphinObject);
                    break;
                case 5:
                    readObjectsFromFile();
                    break;
                default:
                    System.out.println("Sorry no such animal available.");
            }
            System.out.println("Continue main Zoo menu? (Enter 1 for yes/ 2 for no): ");
            continueOuterLoop = keyboard.nextInt();
        } while (continueOuterLoop == 1);
    }

    private static int animalChoiceMenu(Scanner keyboard) {
        int choiceGivenByUser;

        System.out.println("**** ZOO ANIMAL choice menu ****");
        System.out.println("1. Tiger");
        System.out.println("2. Dolphin");
        System.out.println("3. Penguin");

        System.out.println("Enter choice of animal:");
        choiceGivenByUser = keyboard.nextInt();
        return choiceGivenByUser;
    }
    
    private static int animalDetailsManipulationMenu(Scanner keyboard, Animal animal){
        int choiceGivenByUser;

        System.out.println("**** ANIMAL details menu for: ");
        System.out.println("1. Set properties");
        System.out.println("2. Display properties");
        System.out.println("3. Display movement");
        System.out.println("4. Display eating");

        System.out.println("Enter choice (1-4):");
        choiceGivenByUser = keyboard.nextInt();
        return choiceGivenByUser;
    }

    // Write a method named writeObjectsToFile and pass Tiger, Penguin and Dolphin to be saved onto a file.
    public static void writeObjectsToFile(Tiger tiger, Penguin penguin, Dolphin dolphin){

        // Tiger
        try (ObjectOutputStream tigerOut = new ObjectOutputStream(
                new FileOutputStream("tiger.txt"))) {
            tigerOut.writeObject(tiger);
            System.out.println("Tiger saved to tiger.txt");
        } catch (IOException e) {
            System.err.println("Failed to save Tiger file.");
            e.getStackTrace();
        }

        // Penguin
        try (ObjectOutputStream penguinOut = new ObjectOutputStream(
                new FileOutputStream("penguin.txt"))) {
            penguinOut.writeObject(penguin);
            System.out.println("Penguin saved to penguin.txt");
        } catch (IOException e) {
            System.err.println("Failed to save Penguin file.");
            e.getStackTrace();
        }

        // Dolphin
        try (ObjectOutputStream dolphinOut = new ObjectOutputStream(
                new FileOutputStream("dolphin.txt"))) {
            dolphinOut.writeObject(dolphin);
            System.out.println("Dolphin saved to dolphin.txt");
        } catch (IOException e) {
            System.err.println("Failed to save Dolphin file.");
            e.getStackTrace();
        }
    }

    // Read the file tiger.txt, penguin.txt and dolphin.txt
    public static void readObjectsFromFile(){
        try (ObjectInputStream tigerIn = new ObjectInputStream(
            new FileInputStream("tiger.txt"))) {
                Tiger tiger = (Tiger) tigerIn.readObject();
                System.out.println("Tiger Object loaded from tiger.txt");
                tiger.toString();
        } catch (ClassNotFoundException e) {
            System.err.println("File not found.");
            e.getStackTrace();
        } catch (IOException e) {
            System.err.println("Failed to read Tiger from file.");
            e.printStackTrace();
        }

        try (ObjectInputStream penguinIn = new ObjectInputStream(
            new FileInputStream("penguin.txt"))) {
                Penguin penguin = (Penguin) penguinIn.readObject();
                System.out.println("Penguin object loaded from penguin.txt");
                penguin.toString();
        } catch (ClassNotFoundException e) {
            System.err.println("File not found.");
            e.getStackTrace();
        } catch (IOException e) {
            System.err.println("Failed to read Penguin from file.");
            e.printStackTrace();
        }

        try (ObjectInputStream dolphinIn = new ObjectInputStream(
            new FileInputStream("dolphin.txt"))) {
                Dolphin dolphin = (Dolphin) dolphinIn.readObject();
                System.out.println("Dolphin object loaded from dolphin.txt");
                dolphin.toString();
        } catch (ClassNotFoundException e) {
            System.err.println("File not found.");
            e.getStackTrace();
        } catch (IOException e ){
            System.err.println("Failed to read Dolphin from file.");
            e.printStackTrace();
        }
    }
}