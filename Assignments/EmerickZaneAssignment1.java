/*
Name:   Zane Emerick
Class:  CS1150
Due:    Sept 5, 2019
Desc:  Assignment 1
    This program is designed to first print a few sentences about myself, and then calcuate a person's weight on the moon, Mars, and Jupiter.
*/

public class EmerickZaneAssignment1{
    public static void main(String[] args) {
        System.out.println("\nProblem 1: Displaying output:");
        System.out.println("\n\tI am currently a Computer Security major, and I'm originally from Longmont Colorado. I enjoy playing");
        System.out.println("Ultimate Frisbee and doing various programming projects in my free time. Some of my past programming projects");
        System.out.println("involve building a Discord bot using python and building a game website using Javascript and Processing.");
        System.out.println("My dream job is to work doing penetration testing for a security company, and that is why I chose my major.");
        System.out.println("I would also like to work at a rocket company such as SpaceX or Blue Origin doing back-end systems programming.");
        System.out.println("I have a few years of programming background, and took AP Computer Science A in high school so I feel I have at"); 
        System.out.println("least a decent grasp on Java.");

        System.out.println("\n\tI'm an avid reader, and my favorite book is called Ready Player One by Ernest Cline. I also enjoy");
        System.out.println("watching movies and prefer Science Fiction over other genres, with my favorite movie being a tie between Ex");
        System.out.println("Machina and Interstellar. I'm an only child, and I have one dog named Rocco who I took for a walk nearly every day");
        System.out.println("over the summer. I am also an avid hikder, and enjoy backpacking and camping as often as I can. I actually climbed");
        System.out.println("Mount Elbert, one of the tallest mountains in the continental US, the week before class started. I noticed the Rec");
        System.out.println("Center teaches rock climbing classes and I hope to learn more about that so I can go climbing myself one day.");

        System.out.println("\nPart 2: Working with expressions:");
        System.out.println("\nEarth\t\tMoon\t\tMars\t\tJupiter");
        
        for(int i = 0; i < 60; i++){
            System.out.print("-");
        }
        System.out.println("");
        System.out.printf("1\t\t%.3f\t\t%.3f\t\t%.3f\n", moonWeight(1), marsWeight(1), jupiterWeight(1));
        System.out.printf("10\t\t%.3f\t\t%.3f\t\t%.3f\n", moonWeight(10), marsWeight(10), jupiterWeight(10));
        System.out.printf("100\t\t%.3f\t\t%.3f\t\t%.3f\n", moonWeight(100), marsWeight(100), jupiterWeight(100));
        System.out.printf("1000\t\t%.3f\t\t%.3f\t\t%.3f\n", moonWeight(1000), marsWeight(1000), jupiterWeight(1000));
    }


    public static double moonWeight (int weight){ //finds a person's weight on the Moon
        return (weight / 9.81) * 1.622;
    }

    public static double marsWeight (int weight){ //finds a person's weight on Mars
        return (weight / 9.81) * 3.711;
    }

    public static double jupiterWeight (int weight){ //finds a person's weight on Jupiter
        return (weight / 9.81) * 24.79;
    }

    
}