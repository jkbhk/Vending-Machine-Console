import java.util.*;

public class PaymentManager {
	
	public static void displayPaymentMethod() {
		
		System.out.println("Please insert coins: ");
		System.out.println("========== Coins Input ===========");
		System.out.println("Enter 'Q' for ten cents input ");
		System.out.println("Enter 'T' for twenty cents input");
		System.out.println("Enter 'F' for fifty cents input ");
		System.out.println("Enter 'N' for a dollar input ");
		System.out.println("==================================");
	}
	
	public static void requestPayment(Scanner sc, double price, double current) {
		
		char choice = sc.next().charAt(0);
		
		switch(choice) {
			case 'Q':
				current += 0.10;
				break;
			case 'T':
				current += 0.20;
				break;
			case 'F':
				current += 0.50;
				break;
			case 'N':
				current += 1.00;
				break;
			default:
				System.out.println("This ain't a coin...");
				break;
			}
		
		System.out.printf("Coins inserted: %.2f", current);
		System.out.println();

		if(current < price) {
			requestPayment(sc, price, current);
		}else {
			displayChangeMessage(current-price);
		}

		
	}
	
	private static void displayChangeMessage(double change) {
		System.out.printf("Change: $ %.2f", change);
		System.out.println();
	}
	
}
