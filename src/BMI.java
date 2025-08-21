import java.text.DecimalFormat;
import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.0");
        char again = 'y';  // ✅ Initialize here

        do {
            System.out.println("Choose unit system:");
            System.out.println("1. Imperial (pounds, feet, inches)");
            System.out.println("2. Metric (kg, cm)");
            int choice = input.nextInt();

            double BMI = 0.0;

            if (choice == 1) {
                // Imperial system
                System.out.print("Enter weight in pounds: ");
                double weight = input.nextDouble();

                System.out.print("Enter height (feet): ");
                int heightFeet = input.nextInt();

                System.out.print("Enter remaining height (inches): ");
                int heightInches = input.nextInt();

                int totalHeightInches = (heightFeet * 12) + heightInches;
                BMI = (weight / Math.pow(totalHeightInches, 2)) * 703;

            } else if (choice == 2) {
                // Metric system
                System.out.print("Enter weight in kilograms: ");
                double weight = input.nextDouble();

                System.out.print("Enter height in centimeters: ");
                double heightCm = input.nextDouble();

                double heightM = heightCm / 100.0;
                BMI = weight / Math.pow(heightM, 2);

            } else {
                System.out.println("Invalid choice!");
                continue; // restart loop
            }

            // Print BMI value
            System.out.println("\nYour BMI is: " + df.format(BMI));

            // BMI Category
            if (BMI < 18.5) {
                System.out.println("Category: Underweight");
                System.out.println("Tip: Consider a nutritious diet to gain healthy weight.");
            } else if (BMI < 25) {
                System.out.println("Category: Normal weight");
                System.out.println("Tip: Great! Keep maintaining your lifestyle.");
            } else if (BMI < 30) {
                System.out.println("Category: Overweight");
                System.out.println("Tip: Try including regular exercise in your routine.");
            } else {
                System.out.println("Category: Obese");
                System.out.println("Tip: Consult a healthcare professional for guidance.");
            }

            // Ask if user wants to calculate again
            System.out.print("\nDo you want to calculate again? (y/n): ");
            again = input.next().charAt(0);   // ✅ re-assigns again

        } while (again == 'y' || again == 'Y');

        System.out.println("Thank you for using the BMI Calculator!");
        input.close();
    }
}
