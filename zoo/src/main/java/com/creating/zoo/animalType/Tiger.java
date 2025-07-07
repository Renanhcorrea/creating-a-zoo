package com.creating.zoo.animalType;

import java.io.Serializable;
import java.util.Scanner;

import com.creating.zoo.animalAction.Walk;

public class Tiger extends Animal implements Walk, Serializable{
    private static final long serialVariableUID = 1L;

    private int numberOfStripes;
    private double speed;
    private int soundLevel;

    public Tiger() {
        super("Tiger");
    }

    public int getNumberOfStripes() {
        return numberOfStripes;
    }

    public void setNumberOfStripes(int numberOfStripes) {
        this.numberOfStripes = numberOfStripes;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getSoundLevel() {
        return soundLevel;
    }

    public void setSoundLevel(int soundLevel) {
        this.soundLevel = soundLevel;
    }

    @Override
    public void setNameOfAnimal(String nameOfAnimal) {
        super.setNameOfAnimal(nameOfAnimal);
    }

    @Override
    public String getNameOfAnimal() {
        return super.getNameOfAnimal();
    }

    @Override
    public void eatingCompleted(){
        eatingFood();
        System.out.println(getNameOfAnimal() +
                            ": I have eaten meat.");
    }

    @Override
    public void walking() {
        System.out.println(getNameOfAnimal() + 
                            ": I am walking at the speed " +
                            getSpeed());
    }

    public void setProperties(Scanner keyboard){
        System.out.println("Age: ");
        setAge(keyboard.nextInt());
        System.out.println("Weight: ");
        setWeight(keyboard.nextInt());
        System.out.println("Height: ");
        setHeight(keyboard.nextInt());
        System.out.println("Walking speed: ");
        setSpeed(keyboard.nextDouble());
        System.out.println("Number of stripes: ");
        setNumberOfStripes(keyboard.nextInt());
        System.out.println("Level of Roar: ");
        setSoundLevel(keyboard.nextInt());        
    }

    public void displayProperties(){
        System.out.println( getNameOfAnimal() + " Properties:");
        System.out.println("Age: " + getAge());
        System.out.println("Weight" + getWeight());
        System.out.println("Height: " +getHeight());
        System.out.println("Stripes: " +getNumberOfStripes());
        System.out.println("Roar: " + getSoundLevel());
        System.out.println("Walking speed: " + getSpeed());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tiger{");
        sb.append("numberOfStripes=").append(numberOfStripes);
        sb.append(", speed=").append(speed);
        sb.append(", soundLevel=").append(soundLevel);
        sb.append('}');
        return sb.toString();
    }



}
