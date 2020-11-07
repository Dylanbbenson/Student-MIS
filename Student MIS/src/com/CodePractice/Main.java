package com.CodePractice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Prevents program from blowing up if the user inputs the wrong value
        int numOfStudents = 0;
        boolean done = false;
        while (!done)
            try {
                System.out.println("Enter number of new students to enroll: ");
                Scanner input = new Scanner(System.in);
                numOfStudents = input.nextInt();
                done = true;
            } catch (InputMismatchException e) {
                System.out.println("There was a mis-input!");
                System.out.println("Try Again!");
            }

        Student[] students = new Student[numOfStudents];

        // Loops until all students' information has been entered
        for (int n = 0; n < numOfStudents; n++) {
            Student student = new Student();
            student.enroll();
            Thread.sleep(1000);
            student.payTuition();
            System.out.println(student.showInfo());
            Thread.sleep(1000);
        }
        System.out.println("Goodbye");

    }
}
