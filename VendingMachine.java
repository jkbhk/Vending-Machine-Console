
import java.util.*;

public class VendingMachine {
	
	private Product[] products = {
			
			new Product("Beer", 3, false, 99),
			new Product("Coke", 1, false, 10),
			new Product("Green Tea", 5, false, 1)
	};
	
	private final Product DEFAULT_SELECTED = null;
	
	private boolean isRunning = false;
	private Scanner scanner;
	private Product currentSelected;
	

	public VendingMachine() {
		
		scanner = new Scanner(System.in);
		currentSelected = null;
	}
	
	public void start(){
		
		isRunning = true;
		update();
		
	}
	
	public void startOnce() {
		
		isRunning = false;
		update();
	}
	
	private void update() {
		
		do {
		
			displayDynamicMenu();
			
			getInput();
			
			PaymentManager.displayPaymentMethod();
			PaymentManager.requestPayment(scanner, currentSelected.getCost(),0);
			
			dispense();
			
			displayCollectionMessage();
			
			reset();	
			
		}while(isRunning);
		
	}
	
	
	private void getInput() {
		
		int choice = scanner.nextInt();
	
		if(choice <= products.length) {
			
			currentSelected = getProductReference(choice);
			
			if(currentSelected.getStock() <= 0) {
				System.out.println("Sorry, " + currentSelected.getName()+" is out of stock! Choose another.");
				getInput();
			}	
			
			
		}else {
			System.out.println("press properly la");
			getInput();
		}	
	}
	
	private void dispense() {
		currentSelected.deduct(1);
		
		System.out.println("");
		System.out.println("dispensing...");
		System.out.println("");
		delay(1);
	}
	
	private void delay(int s) {
		try {
			Thread.sleep(s*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void displayCollectionMessage() {
		if(currentSelected.isHot())
			System.out.println("CAUTION: HOT!!!");
		
		System.out.println("Please collect your drink");
		System.out.println("Thank You!!");
		System.out.println();
	}
	
	private void reset() {
		currentSelected = DEFAULT_SELECTED;
	}
	
	
	private Product getProductReference(int x) {
		
		// convert choice to index
		return products[x-1];
		
	}
	
	private void displayDynamicMenu() {
		
		String leftAlignFormat = "| %-17s | %-7.2f | %-5d |\n";

		System.out.println("=========== Vending Machine ===========");
		System.out.println("|                                     |");
		System.out.println("| Product name      | Cost($) | Stock |");
		System.out.println("|--------------------------------------");
		
		for (int i = 0; i < products.length; i++) {
			Product temp = products[i];
		    System.out.printf(leftAlignFormat, (i+1) + ") " + temp.getName(), temp.getCost(),temp.getStock());
		}
		
		System.out.println("|=====================================|");
		System.out.println();
		System.out.println("Please enter selection:");
		
	}
	
	
}
