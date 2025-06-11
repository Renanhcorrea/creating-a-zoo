package com.creating.zoo.animalType;

import java.util.Scanner;

import com.creating.zoo.animalAction.Swim;

public class Dolphin extends Animal implements Swim{
    private String color;
    private int swimmingSpeed;

    public Dolphin(){
        super("Dolphin");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(int swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
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
                            getSwimmingSpeed() + 
                            " nautical miles per hour");
    }

    public void setProperties(Scanner keyboard){
        System.out.println("Age: ");
        setAge(keyboard.nextInt());
        System.out.println("Weight: ");
        setWeight(keyboard.nextInt());
        System.out.println("Height: ");
        setHeight(keyboard.nextInt());
        System.out.println("Swimming speed: ");
        setSwimmingSpeed(keyboard.nextInt());
        System.out.println("Color: ");
        setColor(keyboard.next());        
    }

    public void displayProperties(){
        System.out.println( getNameOfAnimal() + " Properties:");
        System.out.println("Age: " + getAge());
        System.out.println("Weight" + getWeight());
        System.out.println("Height: " +getHeight());
        System.out.println("Color: " +getColor());
        System.out.println("Swimming speed: " + getSwimmingSpeed());
    }

}
