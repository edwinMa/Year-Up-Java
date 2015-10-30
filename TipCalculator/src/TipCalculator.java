import java.text.DecimalFormat;
import java.util.Scanner;

public class TipCalculator {
	
	static double checkAmount;

	public static void main(String[] args) {
		System.out.println("What is your bill amount? ");
		Scanner userInput = new Scanner(System.in);
		double checkAmount = userInput.nextDouble();
		
		System.out.println("check amount is: " + checkAmount);

		DecimalFormat df = new DecimalFormat("#.##");
        
		System.out.println("Your tip with 10 percent is: " + calculateTip (checkAmount, 10.0));
		System.out.println("Your tip with 15 percent is: " + calculateTip (checkAmount, 15.0));
		System.out.println("Your tip with 20 percent is: " + calculateTip (checkAmount, 20.0));
		System.out.println("Your tip with 25 percent is: " + calculateTip (checkAmount, 25.0));
		

	}
	
	public static String calculateTip (double checkAmount, double percentage)
	{
		double tipAmount = checkAmount * (percentage/100);
		
		// use decimal format so that we also only show two decimal places
		DecimalFormat df = new DecimalFormat("$#.##");
	
		return (df.format(tipAmount));
	}
	
	

}