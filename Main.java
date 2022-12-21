/*
A certain grade of steel has to be graded according to the following conditions
The hardness of the steel must be >= 50
The carbon content of the steel must be <=0.7.
The tensile strength of the steel must be >5600

If all the conditions are met for a steel -> the grade is 10
If only 1&2 are true -> grade is 9
If only 1&3 are true -> grade is 8
If only 2&3 are true -> grade is 7
If only one condition is true -> grade is 6
If no condition is true -> grade is 0

Now we need to write a program where we shall be reading the values such as Hardness, Carbon content and tensile strength from the user and we would print the grade of the steel based on these values.

*/


import java.util.Scanner;

public class Main{
    public static void main (String[] args) {
        int hardness, tensilestrength;
        double carboncontent;
        
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the hardness: ");
        hardness = s.nextInt();
        System.out.println("Enter the carboncontent: ");
        carboncontent = s.nextDouble();
        System.out.println("Enter the tensile Strength: ");
        tensilestrength = s.nextInt();
        
        if(hardness>=50 && tensilestrength > 5600 && carboncontent <= 0.7)
            System.out.println("Grade is 10");
        else if(hardness >= 50 && carboncontent <= 0.7)
            System.out.println("Grade is 9");
        else if(hardness>=50 && tensilestrength>5600)
            System.out.println("Grade is 8");
        else if(carboncontent<=0.7 && tensilestrength > 5600)
            System.out.println("Grade is 7");
        else if(hardness>=50 || tensilestrength>5600 || carboncontent<=0.7)
            System.out.println("Grade is 6");
        else
            System.out.println("Grade is 0");
    }
}