import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
	
public class new_cashSys {
	
	public static Scanner scan = new Scanner(System.in);
	public static double total = 0;
	public static String items = "", answer = "";
	public static String amount_paid = "";
	public static double amount_paidP= 0;
	public static Object[][] menu = { 
			{"Rice \t", 10.0},
            {"Beef Steak\t", 250.0},
            {"Steak\t", 200.0},
            {"Adobo\t", 180.0},
            {"Afritada\t", 250.0},
            {"Teriyaki\t", 200.0},
            {"Fillet\t", 200.0},
            {"Curry\t", 250.0},
            {"Beef Pares\t", 60.0},
            {"Meat Balls\t", 250.0},
            {"Calamares\t",180.0},
            {"Kawali\t", 180.0}
            
	        };
	// for try catch purposes
	public static boolean loop = false;
	public static String choice = "", mop = "";
	
    public static void main(String[] args) {
    	login();
    	}
    
    public static int login () {
    	// String variables for login
        System.out.println("Login");
    	String username = "1";
    	String password = "1";
    	
        // Variables for input
        String username_input, password_input;
        do {
    	System.out.print("Enter username: ");
    	username_input = scan.next();
    	System.out.print("Enter password: ");
    	password_input = scan.next();
    	
    	if (username_input.equals(username) & password_input.equals(password)) {
    		System.out.println("\n\nLogin Successfully! \n\n");
    		menu();
    	}
        else if (!username_input.equals(username) | !password_input.equals(password)){
            System.out.println("Invalid username or password, please try again\n");
        }
        } while (!username_input.equals(username) | !password_input.equals(password));
    	return 0;
    }
    
    	public static int menu() {
        System.out.println("========= Higala's Grill 746 =========");

        // Display menu
        System.out.println("Select your order:\nItem name\t\t\tPrice");
        for (int i = 0; i < menu.length; i++) {
            System.out.printf("[%d]%s\t\t%.1f\t%n", i+1, menu[i][0], menu[i][1]);
        }
        boolean order_again = true;

        while (order_again) {
        	loop = false;
        	String item_number = "";
        	int item_numberP = 0;
        	do {
        		try {
		        System.out.print("\nEnter item number: ");
		        item_number = scan.next(); 
		        item_numberP = Integer.parseInt(item_number); 
		        if (item_numberP <= 0 | item_numberP >= 12) {
		        	System.out.println("Invalid input, please try again");
		        	loop = true;
		        }
		        else {loop = false;}
		        
        		} catch (Exception e) {
        			System.out.println("Invalid input, please try again");
        			loop = true;
        		}
        	} while (loop);
        	String quantity_entered = "";
        	int quantity_enteredP = 0;
		    do {
		    	try {
	            System.out.print("\nEnter quantity: ");
	            quantity_entered = scan.next();
	            quantity_enteredP = Integer.parseInt(quantity_entered); // P = parsed
	            if (quantity_enteredP <= 0) {
	            	System.out.println("Invalid Input, please try again.");
	            	loop = true;
	            } else {loop = false;}
	            
		    	} catch (Exception e) {
		    		System.out.println("Invalid input, please try again.");
		    		loop = true;
		    	}
	        } while (quantity_enteredP <= 0);
	
	        double price = (double)menu[item_numberP - 1][1]; // Cast the element to double
            double subtotal = price * quantity_enteredP;
            
            String item_name = (String)menu[item_numberP - 1][0]; // Cast the element to string
            items += String.format("%n   %s%.1f\t   %d\t\t%.1f" , item_name, price, quantity_enteredP, subtotal);
            total += subtotal;
            System.out.printf("%n    Item Name\tPrice\tQuantity\tSubtotal%n");
            System.out.println(items);
	            
            do {
            	System.out.print("\nOrder again (y/n)? ");
                answer = scan.next();
            if (answer.equalsIgnoreCase("y")) {
            	order_again = true;
            	break;
            }
            else if (answer.equalsIgnoreCase("n")) {
                order_again = false;
                do { 
                System.out.print("\n\nDine in or take out? (D for dine in / T for take-out) ");
                choice = scan.next();
                if (choice.equalsIgnoreCase("d")) {choice = "DINE IN";}
                else if (choice.equalsIgnoreCase("t")) {choice = "TAKE-OUT";}
                else  {
                	System.out.println("Invalid input, please try again. \n");
                }
                } while (!choice.equalsIgnoreCase("DINE IN") & !choice.equalsIgnoreCase("TAKE-OUT"));
                payment();
            }
            else if (!answer.equalsIgnoreCase("y") | !answer.equalsIgnoreCase("n"));{
            	System.out.println("Invalid Input, please try again."); 
            	}
            
            } while (!answer.equalsIgnoreCase("y") | !answer.equalsIgnoreCase("n"));
        	}
	        return 0;
	        }
    	
    	public static int payment () {
    		do {
    			do {
    				System.out.println("\n\nSelect mode of payment:\n1. Cash \n2. Credit/Debit Card \n3. Mobile Wallet ");
    				mop = scan.next(); // mop or "Mode of Payment"
    				if (mop.equals("1")) {mop = "Cash"; loop = false;}
    				else if (mop.equals("2")) {mop = "Credit/Debit Card"; loop = false;}
    				else if (mop.equals("3")) {mop = "Mobile Wallet"; loop = false;}
    				else { System.out.println("Invalid input, please try again.\n");
    					loop = true;
    				} 
    			} while (loop);
	        	
	        		if (mop =="Cash") { loop = true;
	        			while (loop) {
	        				try {
	        		System.out.printf("%n    Item Name\tPrice\tQuantity\tSubtotal%s%n%n\n", items);
	    	        System.out.printf("%nTotal\t\t.....................   %.1f%n", total);
		        	System.out.print("Amount Paid\t.....................   ");
		        	
		        	amount_paid = scan.next();
		        	amount_paidP = Double.parseDouble(amount_paid);
		        	
		        	if (amount_paidP < total) {
		        	System.out.println("\nInsufficient amount, Please try again.\n\n");
		        	loop = true;
	        	}
	        	else {
	        		loop = false;
	        		receipt (); }
	        				} catch (NumberFormatException e) {
		        		System.out.println("\nInvalid input, please enter a number.");
		        		loop = true;
		        	}
	        	}
	        	}
	        		else if (mop == "Credit/Debit Card" | mop == "Mobile Wallet") {
	        			amount_paidP = total;
	        			receipt();
	        		}
	        	
	        } while (loop);
    		return 0;
    	}
	    
	
        public static int receipt () {
        	// Print receipt
	        System.out.printf("%n============== Higala's Grill 746 ==============%n");
	        				//	 ------------------------------------------------------
	        System.out.printf("%n\t\t Official Receipt%n");
	
	        Date date = new Date();
	        SimpleDateFormat formatter = new SimpleDateFormat("MM/DD/YYYY HH:MM:SS");
	        System.out.println("\n\t     128, Ferrabrel street, "
                    		+ "\n\t     Carmen, Cagayan de Oro\n"
                    		+ "\tContact #: 09774973757");
	        System.out.println("------------------------------------------------");
	        System.out.printf("Date/Time: %s%n", formatter.format(date));
            System.out.println("------------------------------------------------");
            System.out.println("===================="+choice+"====================");
	
	        System.out.printf("%n    Item Name\tPrice\tQuantity\tSubtotal%s%n%n", items);
	        System.out.printf("%nTotal\t\t.....................   %.1f%n", total);
	        System.out.println("Amount Paid\t.....................   "+ amount_paidP);
	        	
	        double change = amount_paidP - total;
	        System.out.printf("Change\t\t.....................   %.1f%n", change);
	        System.out.println("\n------------------------------------------------"
	        		    	 + "\nMode of payment: "+ mop + "  Cashier: Naaars\n"
	        		    	 + "------------------------------------------------");
	
	        System.out.println("\n\t\tThank you!");
	        
	        do {
	        	System.out.print("\n\nOrder again (y/n)? ");
	            String answer = scan.next();
	            if (answer.equalsIgnoreCase("y")) {
                        items = "";
                        total = 0;
	            	menu();
	        		}
	            else if (answer.equalsIgnoreCase("n")) {
	            	break;
	            }
	            else {
	            	System.out.println("Invalid Input, please try again.");
	            }
	        } while (!answer.equalsIgnoreCase("y") | !answer.equalsIgnoreCase("n"));
	        System.exit(0);
	        return 0;
	        }
}