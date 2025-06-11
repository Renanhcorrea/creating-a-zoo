package com.creating.zoo;

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
}