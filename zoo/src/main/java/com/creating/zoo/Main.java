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

        int continueOuterLoop =1;
        int continueInnerLoop =1;

        // Menu choice
        int menuChoice =1;
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
                                tigerObject.eatingFood();
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
        System.out.println("4. Save animals to file");
        System.out.println("5. Display saved animals from file");
        System.out.println("Enter choice of animal (1-5): ");
        choiceGivenByUser = keyboard.nextInt();
        return choiceGivenByUser;
    }
    
    private static int animalDetailsManipulationMenu(Scanner keyboard, Animal animal){
        int choiceGivenByUser;

        System.out.println("**** ANIMAL details menu for: " + animal.getNameOfAnimal() + " ****");
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
        try (ObjectOutputStream tigerOut = new ObjectOutputStream(
                new FileOutputStream("tiger.txt"));
             ObjectOutputStream penguinOut = new ObjectOutputStream(
                new FileOutputStream("penguin.txt"));
             ObjectOutputStream dolphinOut = new ObjectOutputStream(
                new FileOutputStream("dolphin.txt"))) {
            tigerOut.writeObject(tiger);
            penguinOut.writeObject(penguin);
            dolphinOut.writeObject(dolphin);
            System.out.println("Animal state saved sucessfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read the file tiger.txt, penguin.txt and dolphin.txt
    public static void readObjectsFromFile(){
        try (ObjectInputStream tigerIn = new ObjectInputStream(
            new FileInputStream("tiger.txt"));
            ObjectInputStream penguinIn = new ObjectInputStream(
            new FileInputStream("penguin.txt"));
            ObjectInputStream dolphinIn = new ObjectInputStream(
            new FileInputStream("dolphin.txt"))) {
                Tiger tiger = (Tiger) tigerIn.readObject();
                Penguin penguin = (Penguin) penguinIn.readObject();
                Dolphin dolphin = (Dolphin) dolphinIn.readObject();
                System.out.println("Tiger data retrieved from file: " + tiger.toString());
                System.out.println("Penguin data retrieved from file: " + penguin.toString());
                System.out.println("Dolphin data retrieved from file: " + dolphin.toString());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}