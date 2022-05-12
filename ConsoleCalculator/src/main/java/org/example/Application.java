package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class Application {

    @Bean
    public void start() {
        choice();
    }

    @Bean
    public double num1() {

        double num1;
        System.out.println("Enter first number: ");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextDouble()) {
            num1 = sc.nextDouble();
        } else {
            System.out.println("Error. Please try again");
            num1 = num1();
        }
        return num1;
    }

    @Bean
    public double num2() {

        double num2;
        System.out.println("Enter second number: ");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextDouble()) {
            num2 = sc.nextDouble();
        } else {
            System.out.println("Error. Please try again");
            num2 = num2();
        }
        return num2;
    }

    @Bean
    public String getOperation() {
        Scanner sc = new Scanner(System.in);
        String operation = null;
        String a = "+";
        String b = "-";
        String c = "*";
        String d = "/";
        System.out.println("Enter your operation");
        String i = sc.nextLine();
        if (i.equals(a) || i.equals(b) || i.equals(c) || i.equals(d)) {
            operation = i;
        } else {
            System.out.println("Incorrect value. Try again");
            getOperation();
        }
        return operation;
    }

    @Bean
    public void calc() {
        double i = num1();
        double j = num2();
        double result = 0;
        String operation = getOperation();
        switch (operation) {
            case "+":
                result = i + j;
                break;
            case "-":
                result = i - j;
                break;
            case "*":
                result = i * j;
                break;
            case "/":
                result = i / j;
                break;
            default:
                System.out.println("Something went wrong. Try again");
                getOperation();
                break;
        }
        System.out.println("Operation result: " + result);
    }

    @Bean
    public void choice() {
        Scanner sc = new Scanner(System.in);
        String a = "1";
        String b = "2";
        System.out.println("Select an action: ");
        System.out.println("Press 1 for calculator");
        System.out.println("Press 2 to exit");
        String n = sc.nextLine();
        if (n.equals(a)) {
            calc();
        } else if (n.equals(b)) {
            System.out.println("Good Bye!");
        } else {
            System.out.println("Incorrect value. Try again");
            choice();
        }
    }
}


