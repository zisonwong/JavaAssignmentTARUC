/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p1q1;
import java.util.Scanner;
/**
 *
 * @author zison
 */
public class P1Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter Name:");
        String name = scanner.nextLine();
        System.out.println("Student's name is "+ name + "." );
        
        
        System.out.print("Year of study:");
        int yearOfStudy = scanner.nextInt();
        System.out.println("Current year of study is "+ yearOfStudy + ".");
        
        
        System.out.print("Target GPA for this semester:");
        double gpa = scanner.nextDouble();
        System.out.println("Target GPA is "+ gpa + ".");
               
        System.out.println("Welcome "+ name + "!");
        System.out.println("Work hard to achieve your target GPA of " + gpa + " this semester of your Year " + yearOfStudy + ".");
    }
    
}
