import java.util.Scanner;

public class StudentGradeCalculator 
{

    private static final double GRADE_A = 90.0;
    private static final double GRADE_B = 80.0;
    private static final double GRADE_C = 70.0;
    private static final double GRADE_D = 60.0;

    public static void main(String arg[])
    {
        Scanner scan = new Scanner(System.in);
        String name;
        // Input name of student
        System.out.println("Enter name of Student:");
        name=scan.next();

        // Input number of subjects
        System.out.print("Enter total number of subjects: ");
        int numberOfSubjects = scan.nextInt();

        // Input marks for each subject
        double total = 0.0;
        for (int i = 1; i <= numberOfSubjects; i++) 
        {
            System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
            double marks = scan.nextDouble();
            
            // Checking whether input marks given are between 0 and 100 or not!!
            while (marks < 0 || marks > 100) 
            {
                System.out.println("Invalid input!! Marks should be between 0 and 100.");
                System.out.print("Re-enter marks for subject " + i + ": ");
                marks = scan.nextDouble();
            }

            total += marks;
        }

        // Calculate average percentage
        double averagePercentage = (total / (numberOfSubjects * 100)) * 100;

        // Determine the grade
        char grade = calculateGrade(averagePercentage);

        // Display results
        System.out.println("Result of student "+name+" is displayed below:");
        System.out.println("Total Marks: " + total);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }

    // Method to calculate grade based on percentage
    private static char calculateGrade(double percentage) {
        if (percentage >= GRADE_A) 
        {
            return 'A';
        }
        
        else if (percentage >= GRADE_B) 
        {
            return 'B';
        } 
        
        else if (percentage >= GRADE_C)
        { 
            return 'C';
        } 
        
        else if (percentage >= GRADE_D) 
        {
            return 'D';
        } 
        
        else       
        {
            return 'F'; // Failing grade
        }
    }
}
