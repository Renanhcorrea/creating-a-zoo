package com.creating.zoo.animalType;

import java.util.Scanner;

import com.creating.zoo.animalAction.Swim;
import com.creating.zoo.animalAction.Walk;

public class Penguin extends Animal implements Walk, Swim{
    private int walkSpeed;
    private int swimSpeed;
    private boolean isSwimming;

    public Penguin() {
        super("Penguin");
    }

    public int getWalkSpeed() {
        return walkSpeed;
    }

    public void setWalkSpeed(int walkSpeed) {
        this.walkSpeed = walkSpeed;
    }

    public int getSwimSpeed() {
        return swimSpeed;
    }

    public void setSwimSpeed(int swimSpeed) {
        this.swimSpeed = swimSpeed;
    }

    public boolean isIsSwimming() {
        return isSwimming;
    }

    public void setSwimming(boolean Swimming) {
        this.isSwimming = Swimming;
    }

    @Override
    public void eatingCompleted(){
        eatingFood();
        System.out.println(getNameOfAnimal() +
                            ": I am eating delicious fish.");
    }

    @Override
    public void swimming() {
        System.out.println(getNameOfAnimal() +
                            ": I am swimming at the speed of " +
                            getSwimSpeed());
    }

    @Override
    public void walking() {
        System.out.println(getNameOfAnimal() + 
                            ": I am walking at the speed " +
                            getWalkSpeed());
    }

    public void setProperties(Scanner keyboard){
        System.out.println("Age: ");
        setAge(keyboard.nextInt());
        System.out.println("Weight: ");
        setWeight(keyboard.nextInt());
        System.out.println("Height: ");
        setHeight(keyboard.nextInt());
        if(isSwimming){
            System.out.println("Swimming speed: ");
            setSwimSpeed(keyboard.nextInt());
        } else {
            System.out.println("Walking speed: ");
            setWalkSpeed(keyboard.nextInt());
        }  
    }

    public void displayProperties(){
        System.out.println( getNameOfAnimal() + " Properties:");
        System.out.println("Age: " + getAge());
        System.out.println("Weight" + getWeight());
        System.out.println("Height: " +getHeight());
        if (isSwimming) {
            System.out.println("Swimming speed: " +getSwimSpeed());
        } else {
            System.out.println("Walking speed: " +getWalkSpeed());
        }
    }

}
