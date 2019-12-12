import java.io.File;
import java.util.Scanner;
import java.io.IOException;

//final grade: 94
//code was corrected after

/**
 * Name: Zane Emerick 
 * Class: CS1150 
 * Assignment #12 
 * Due: December 5, 2019
 * 
 * Description: Create a parent class named Animal, and create child classes for different animals.
 *              Then perform manipulations and display the Animal objects to show knowledge of polymorphism
 *              and inheritance.
 */

public class EmerickZaneAssignment12 {
    public static void main(String[] args) throws IOException {
        //create array of Animals
        Animal[] animals = new Animal[5];

        File inputFile = new File("assignment12.txt");
        Scanner input = new Scanner(inputFile);


        //loop through array and create animal objects
        for(int i = 0; i < animals.length; i++) {
            String type = input.next();
            String name = input.next();
            double weight = input.nextDouble();
            String  food = input.next();
            String location = input.next();

            switch(type) {
                case "Panther":
                    animals[i] = new Panther(name, food, location, weight);
                    break;
                case "Penguin":
                    animals[i] = new Penguin(name, food, location, weight);
                    break;
                case "Bear":
                    animals[i] = new Bear(name, food, location, weight);
                    break;
                case "Wolf":
                    animals[i] = new Wolf(name, food, location, weight);
                    break;
            }
        }

        //loop through array to set types of animals, for display
        for(int index = 0; index < animals.length; index++) {

            if(animals[index] instanceof Panther) {
                System.out.printf("%nAnimal[%d] is a %s%n", index, "Panther");
            } else if(animals[index] instanceof Penguin) {
                System.out.printf("%nAnimal[%d] is a %s%n", index, "Penguin");
            } else if(animals[index] instanceof Bear) {
                System.out.printf("%nAnimal[%d] is a %s%n", index, "Bear");
            } else if (animals[index] instanceof Wolf) {
                System.out.printf("%nAnimal[%d] is a %s%n", index, "Wolf");
            }

            //display results
            System.out.println(animals[index].toString());
            animals[index].eat();
            animals[index].sleep();
            animals[index].swim();

        }
        input.close();

    }
}

class Animal {
    private String name;
    private String food;
    private String location;
    private double weight;

    public Animal(String name, String food, String location, double weight) {
        this.name = name;
        this.food = food;
        this.location = location;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getFood() {
        return food;
    }

    public String getLocation() {
        return location;
    }

    public double getWeight() {
        return weight;
    }

    public void eat() {
        System.out.println("Animal is eating.");
    }

    public void sleep() {
        System.out.println("Animal is sleeping. Please do not disturb.");
    }

    public void swim() {
        System.out.println("Animal is swimming.");
    }
}

class Panther extends Animal {
    public Panther(String name, String food, String location, double weight) {
        super(name, food, location, weight);
    }

    @Override
    public void eat() {
        System.out.println("Panther is eating " + getFood());
    }

    @Override
    public void sleep() {
        System.out.println("Panther is sleeping");
    }

    @Override
    public String toString(){
        return ("Panther name: " + getName() + " weight: " + getWeight() + " lbs location: " + getLocation());
    }
}

class Penguin extends Animal {
    public Penguin(String name, String food, String location, double weight) {
        super(name, food, location, weight);
    }

    @Override
    public void eat() {
        System.out.println("Penguin is eating " + getFood());
    }

    @Override
    public void swim() {
        System.out.println("Penguin is swimming");
    }

    @Override
    public String toString(){
        return ("Penguin name: " + getName() + " weight: " + getWeight() + " lbs location: " + getLocation());
    }
}

class Bear extends Animal {
    public Bear(String name, String food, String location, double weight) {
        super(name, food, location, weight);
    }

    @Override
    public void eat() {
        System.out.println("Bear is eating " + getFood());
    }

    @Override
    public void sleep() {
        System.out.println("Bear is sleeping");
    }

    @Override
    public void swim() {
        System.out.println("Bear is swimming");
    }

    @Override
    public String toString(){
        return ("Bear name: " + getName() + " weight: " + getWeight() + " lbs location: " + getLocation());
    }
}

class Wolf extends Animal {
    public Wolf(String name, String food, String location, double weight) {
        super(name, food, location, weight);
    }

    @Override
    public String toString(){
        return ("Wolf name: " + getName() + " weight: " + getWeight() + " lbs location: " + getLocation());
    }
}