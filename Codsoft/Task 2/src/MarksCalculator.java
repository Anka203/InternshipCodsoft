import java.util.Scanner;  

public class MarksCalculator {  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
        
        System.out.print("Enter the number of subjects: ");  
        int numberOfSubjects = scanner.nextInt();  
        
        int[] marks = new int[numberOfSubjects];  
        int totalMarks = 0;  

        for (int i = 0; i < numberOfSubjects; i++) {  
            System.out.print("Enter marks for subject " + (i + 1) + " out of 100: ");  
            marks[i] = scanner.nextInt();  
            totalMarks += marks[i];  
        }  

        double averagePercentage = (double) totalMarks / numberOfSubjects;  
        String grade = calculateGrade(averagePercentage);  
        
        System.out.println("\nResults:");  
        System.out.println("Total Marks: " + totalMarks + " out of " + (numberOfSubjects * 100));  
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);  
        System.out.println("Grade: " + grade);  

        scanner.close();  
    }  

    public static String calculateGrade(double averagePercentage) {  
        if (averagePercentage >= 90) {  
            return "A+";  
        } else if (averagePercentage >= 80) {  
            return "A";  
        } else if (averagePercentage >= 70) {  
            return "B";  
        } else if (averagePercentage >= 60) {  
            return "C";  
        } else if (averagePercentage >= 50) {  
            return "D";  
        } else {  
            return "F";  
        }  
    }  
}