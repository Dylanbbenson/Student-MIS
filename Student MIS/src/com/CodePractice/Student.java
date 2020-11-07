package com.CodePractice;

import java.util.Random;
import java.util.Scanner;

public class Student {
        private final String firstName;
        private final String lastName;
        private int gradeLevel;
        private String gradeYear;
        private String email;
        private static String studentID;
        Random random = new Random();
        private final int ID = random.nextInt(9000) + 1000;
        private String courses = "";
        private int tuitionBalance = 0;
        private int excessFunds = 0;
        private static final int costOfCourse = 600;

        // Asks the user to input the student's name and grade level, and gives the student an ID
        public Student() {
            Scanner input = new Scanner(System.in);

            System.out.println("Enter the student's first name: ");
            firstName = input.nextLine();
            System.out.println("Enter the student's last name: ");
            lastName = input.nextLine();

            // Do While loop fixes bug in program where the user enters number that's not listed
             do {
                 System.out.println("1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior\n5 - 5th Year Student" +
                         "\n0 - Cancel\nEnter " + firstName + "'s grade level: ");
                gradeLevel = input.nextInt();
                setGradeLevel();
            } while (gradeYear.equals("Misinput"));

            setStudentID();
            setEmail();

        }

        // Creates ID for Student
        private void setStudentID() {
            studentID = gradeLevel + "" + ID;
        }

        // Creates email for Student
        private void setEmail(){
             email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@university.nd.us";
        }

        // Transforms the user's integer input of grade level into a String value of that grade level
        private void setGradeLevel() {
                switch (gradeLevel) {
                    case 1:
                        gradeYear = "Freshman";
                        break;
                    case 2:
                        gradeYear = "Sophomore";
                        break;
                    case 3:
                        gradeYear = "Junior";
                        break;
                    case 4:
                        gradeYear = "Senior";
                        break;
                    case 5:
                        gradeYear = "5th Year Student";
                        break;
                    case 0:
                        gradeYear = "Unknown";
                        break;
                    default:
                        System.out.println("There was a Misinput!\nTry Again");
                        gradeYear = "Misinput";
                }
        }

        /* Asks the user if they want to see the course catalog. If yes, it displays the course catalog and
           allows the user to choose courses for the student. */
        public void enroll() {
                System.out.println("Would you like to enroll " + firstName + " in course(s)? (Y or N)");
                Scanner input = new Scanner(System.in);
                String seeCatalog = input.nextLine();
                if (seeCatalog.equals("Y") || seeCatalog.equals("y")){
                    System.out.println("All courses are $600 each\n1 - English 101\n2 - Maths 215\n3 - Biology 170\n4 - Psychology 181" +
                            "\n5 - History 220\n6 - Art 160\n7 - CS 50\n0 - Cancel");
                }   else if (seeCatalog.equals("N") || seeCatalog.equals("n")){
                    return;
                }   else {
                    System.out.println("Command not recognized\nTry Again");
                    return;
                }

            do {
                System.out.println("Enter course to enroll (Press Q when you're done): ");
                String course = input.nextLine();
                if (!course.equals("Q") && !course.equals("q")) {
                    switch (course) {
                        case "1":
                            course = "English 101";
                            tuitionBalance += costOfCourse;
                            System.out.println("Enrolled in English 101\n" + "Total balance: " + tuitionBalance);
                            break;
                        case "2":
                            course = "Maths 215";
                            tuitionBalance += costOfCourse;
                            System.out.println("Enrolled in Maths 215\n" + "Total balance: " + tuitionBalance);
                            break;
                        case "3":
                            course = "Biology 170";
                            tuitionBalance += costOfCourse;
                            System.out.println("Enrolled in Biology 170\n" + "Total balance: " + tuitionBalance);
                            break;
                        case "4":
                            course = "Psychology 181";
                            tuitionBalance += costOfCourse;
                            System.out.println("Enrolled in Psychology 181\n" + "Total balance: " + tuitionBalance);
                            break;
                        case "5":
                            course = "History 220";
                            tuitionBalance += costOfCourse;
                            System.out.println("Enrolled in History 220\n" + "Total balance: " + tuitionBalance);
                            break;
                        case "6":
                            course = "Art 160";
                            tuitionBalance += costOfCourse;
                            System.out.println("Enrolled in Art 160\n" + "Total balance: " + tuitionBalance);
                            break;
                        case "7":
                            course = "CS 50";
                            tuitionBalance += costOfCourse;
                            System.out.println("Enrolled in CS 50\n" + "Total balance: " + tuitionBalance);
                            break;
                        case "0":
                            break;
                        default:
                            course = "Command not recognized";
                    }
                    courses += "\n" + course;
                } else {
                    break;
                }
            } while (1 != 0);
        }

        // Displays the student's tuition balance
        public void viewBalance() {
            System.out.println(firstName + "'s tuition balance is: $" + tuitionBalance);
        }

        // Allows the user to see student's balance and decide whether or not to make a payment
        // Method will skip all together if Tuition Balance is 0
        public void payTuition() {
            if (tuitionBalance > 0) {
                viewBalance();
                System.out.println("Would you like to make a payment for " + firstName + "? (Y or N)");
                Scanner input = new Scanner(System.in);
                String makePayment = input.nextLine();
                    if (makePayment.equals("Y") || makePayment.equals("y")) {
                        System.out.print("Enter your payment amount: $");
                        int payment = input.nextInt();
                        if (payment > tuitionBalance){
                            excessFunds = tuitionBalance - payment;
                            System.out.println("You get $" + Math.abs(excessFunds) + " back");
                            tuitionBalance = 0;
                        } else {
                            tuitionBalance -= payment;
                            System.out.println("Thank you for your payment of $" + payment);
                        }
                        viewBalance();

                    } else if ((makePayment.equals("N") || makePayment.equals("n"))) {
                        System.out.println(firstName + "'s final balance is $" + tuitionBalance + "\n");
                    } else {
                        System.out.println("Invalid input");
                    }
                }

        }

            // Displays all of the student's information
        public String showInfo() {
            return "Name: " + firstName + " " + lastName + "\nStudent ID: " + studentID + "\nUniversity Email: " + email + "\nGrade Level: " +
                    gradeYear + "\nCourses Enrolled in: " + courses + "\nTuition Balance: $" + tuitionBalance + "\n--------------------------";
    }

}
