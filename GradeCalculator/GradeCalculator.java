
import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int numberOfSubjects;

        // Validate number of subjects
        while (true) {
            System.out.print("Enter the number of subjects: ");

            if (input.hasNextInt()) {
                numberOfSubjects = input.nextInt();

                if (numberOfSubjects > 0) {
                    break;
                } else {
                    System.out.println("Number of subjects must be greater than 0.");
                }
            } else {
                System.out.println("Invalid input! Please enter a whole number.");
                input.next(); // Remove invalid input
            }
        }

        int totalMarks = 0;

        // Input marks with validation
        for (int i = 1; i <= numberOfSubjects; i++) {

            while (true) {
                System.out.print("Enter marks for Subject " + i + " (0-100): ");

                if (input.hasNextInt()) {

                    int marks = input.nextInt();

                    if (marks >= 0 && marks <= 100) {
                        totalMarks += marks;
                        break;
                    } else {
                        System.out.println("Marks must be between 0 and 100.");
                    }

                } else {
                    System.out.println("Invalid input! Please enter a number.");
                    input.next(); // Remove invalid input
                }
            }
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // Assign grade
        char grade;

        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display Results
        System.out.println("\n========== Student Result ==========");
        System.out.println("Number of Subjects : " + numberOfSubjects);
        System.out.println("Total Marks        : " + totalMarks + " / " + (numberOfSubjects * 100));
        System.out.printf("Average Percentage : %.2f%%\n", averagePercentage);
        System.out.println("Grade              : " + grade);
        System.out.println("====================================");

        input.close();
    }
}
