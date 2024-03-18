import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/* Reading information about insurance policies from a text file
 * and displaying the information. */
public class Demo 
{
    public static void main(String[] args) 
    {
        ArrayList<Policy> policies = readPolicyInformationFromFile("C:/Venkat/Project2/PolicyInformation.txt");

        // Display policy information
        for (Policy policy : policies) {
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder's First Name: " + policy.getFirstName());
            System.out.println("Policyholder's Last Name: " + policy.getLastName());
            System.out.println("Policyholder's Age: " + policy.getAge());
            System.out.println("Policyholder's Smoking Status: " + policy.getSmokingStatus());
            System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
            System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
            System.out.printf("Policyholder's BMI: %.2f\n", policy.calculateBMI());
            System.out.printf("Policy Price: $%.2f\n\n", policy.calculateInsurancePrice());
        }

        // Display the number of smokers and non-smokers
        int smokers = countSmokers(policies);
        int nonSmokers = policies.size() - smokers;
        System.out.println("Number of Smokers: " + smokers);
        System.out.println("Number of Non-Smokers: " + nonSmokers);
    }
    
     /* Reads policy information from a text file and creates Policy objects.
     * @param filename The name of the file containing policy information.
     * @return An ArrayList containing Policy objects.
     */
    public static ArrayList<Policy> readPolicyInformationFromFile(String filename) 
    {
        ArrayList<Policy> policies = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String policyNumber = scanner.nextLine();
                String providerName = scanner.nextLine();
                String firstName = scanner.nextLine();
                String lastName = scanner.nextLine();
                int age = Integer.parseInt(scanner.nextLine());
                String smokingStatus = scanner.nextLine();
                int height = Integer.parseInt(scanner.nextLine());
                int weight = Integer.parseInt(scanner.nextLine());

                policies.add(new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight));
            }
            scanner.close();
        } catch (FileNotFoundException e) 
        {
            System.out.println("File not found: " + e.getMessage());
        }

        return policies;
    }

    /*Counts the number of smokers among the policyholders.
     * @param policies An ArrayList containing Policy objects.
     * @return The number of smokers.
     */
    public static int countSmokers(ArrayList<Policy> policies) 
    {
        int count = 0;
        for (Policy policy : policies) 
        {
            if (policy.getSmokingStatus().equalsIgnoreCase("smoker")) 
            {
                count++;
            }
        }
        return count;
    }
}
