import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;

public class ShoppingCart {
	
	static final double TaxRate = 1.075; // constant for tax rate
	static final double CashLimit = 100; // constant for cash vs. credit limit
	
	// instance variables
	ArrayList<Double> items;	// contains shopping cart items
	
	// constructor for shopping cart
	ShoppingCart ()
	{
		// create arrayList to hold shopping cart items
		this.items = new ArrayList<Double>();
	}
	
	/*
	 * display all the items in the shopping cart
	 */
	public void displayItems (DecimalFormat df)
	{
		// iterate over and display item list
		String amount = null;
		for (int j = 0; j < items.size(); j++)
		{
			amount = df.format(items.get(j));
			System.out.println ("cost of item " + (j+1) + " is " + amount);
		}
	}

	/*
	 * add an item to the cart
	 */
	public void addItem (Double item)
	{
		items.add(item);
	}
	
	/*
	 * remove the item at the given index from the cart
	 */
	public void removeItem (int itemIndex)
	{
		items.remove(itemIndex);
	}
	
	/*
	 * return the number of items in the cart
	 */
	public int itemCount ()
	{
		return items.size();
	}
	
	/*
	 * add up items in shopping cart and return total not including tax
	 */
	public double calculateItemTotal ()
	{
		// iterate over all items and add them up and return the total
		double total = 0;
		for (int j = 0; j < items.size(); j++)
		{
			total = total + items.get(j);
		}
		return (total);
	}
	
	/*
	 * empty the items in the cart
	 */
	public void removeAllItems ()
	{
		items.clear();
	}
	
	public static void main(String[] args)
	{
		// create scanner to get user input
		Scanner userInput = new Scanner(System.in);
		
		// create a decimal format to display prices
		DecimalFormat df = new DecimalFormat("$#.##");
	
		// create the shopping cart
		ShoppingCart cart = new ShoppingCart ();
		
		// ask the user if they want to shop and keep shopping until they enter
		// something other than 'y'
		System.out.println ("Would you like to begin shopping? (y/n)");
		String shop = userInput.next();
		
		while (shop.equals("y"))
		{
			// get shopping item prices from user
			getUserItems (userInput, cart);
		
			// ask user to enter item id to remove or -1 when done
			removeUserItems (userInput, cart, df);
		
			// add up all items
			double itemTotal = cart.calculateItemTotal();
			System.out.println ("total amount is " + df.format(itemTotal));
		
			// add tax to items to get full total
			double totalWithTax = addTax (itemTotal, TaxRate);
		
			System.out.println ("Your total bill including tax is " + df.format (totalWithTax));
		
			// if total bill is less than cash limit, let user know
			if (totalWithTax <= CashLimit)
			{
				System.out.println ("Your total bill is under $100 so please pay with cash");
			}
			else
			{
				System.out.println ("Your total bill is over $100. You are eligible for a new credit line");
			}
			
			// empty shopping cart
			cart.removeAllItems();
			
			// ask user if they want to continue shopping
			System.out.println ("Would you like to continue shopping with a new cart? (y/n)");
			shop = userInput.next();
		}
		
		System.out.println ("Thank you for shopping with us.");
		
	}
	
	/*
	 * get individual item prices from user or -1 when done
	 */
	public static void getUserItems (Scanner userInput, ShoppingCart shoppingCart)
	{
		double itemAmount = 0.0; // amount entered by user
		boolean done = false;
		
		// ask user to enter item prices or -1 when done
		while (!done)
		{
			System.out.println("Enter an item price or -1 if you are done");
					
			itemAmount = userInput.nextDouble();
			if (itemAmount != -1)
			{
				shoppingCart.addItem(new Double (itemAmount));
			}
			else
			{
				System.out.println("no more shopping cart items");
				done = true;
			}
		}
	}
	
	/*
	 * ask user if he/she wants to remove any items or enter -1 to continue
	 */
	public static void removeUserItems (Scanner userInput, ShoppingCart shoppingCart, DecimalFormat df)
	{
		// ask user to enter item id to remove or -1 when done
		boolean done = false;
		int itemIndex = -1;
		while (!done)
		{
			// iterate over and display item list
			shoppingCart.displayItems (df);
		
			System.out.println("Enter the number of the item you would like to delete or enter -1 if you are done");
		
			itemIndex = userInput.nextInt();
			if (itemIndex != -1)
			{
			
				System.out.println("removing item #" + itemIndex);
				// subtract 1 from user entered item index in order to adapt to array index starting at 0
				shoppingCart.removeItem(itemIndex - 1);
			}
			else
			{
				System.out.println("the shopping list is final");
				done = true;
			}
		}
	}
	
	/*
	 * add tax to total and return new total
	 */
	public static double addTax (double itemTotal, double taxRate)
	{
		return (itemTotal * taxRate);
	}
	
}