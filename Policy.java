import java.util.ArrayList;

/**
 * Represents an insurance policy for one person.
 */
public class Policy 
{
    private String policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private int height; // in inches
    private int weight; // in pounds

    /**
     * Constructs a Policy object with default values.
     */
    public Policy() 
    {
        policyNumber = "";
        providerName = "";
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "";
        height = 0;
        weight = 0;
    }

    /**
     * Constructs a Policy object with given parameter values.
     */
    public Policy(String policyNumber, String providerName, String firstName, String lastName, int age, String smokingStatus, int height, int weight) {
        policyNumber = policyNumber;
        providerName = providerName;
        firstName = firstName;
        lastName = lastName;
        age = age;
        smokingStatus = smokingStatus;
        height = height;
        weight = weight;
    }

    /*
     * Calculates and returns the BMI (Body Mass Index) of the policyholder.
     * @return The BMI of the policyholder.
     */
    public double calculateBMI() {
        return (weight * 703.0) / (height * height);
    }

    /*
     * Calculates and returns the price of the insurance policy.
     * @return The price of the insurance policy.
     */
    public double calculateInsurancePrice() 
    {
        double baseFee = 600;
        double additionalFee = 0;

        if (age > 50) 
        {
            additionalFee += 75;
        }
        if (smokingStatus.equalsIgnoreCase("smoker")) 
        {
            additionalFee += 100;
        }
        if (calculateBMI() > 35) 
        {
            additionalFee += (calculateBMI() - 35) * 20;
        }

        return baseFee + additionalFee;
    }
}
