package CollectionsProjects;

import java.util.*;

public class Customer3 extends Owner3 {
	Scanner sc = new Scanner(System.in);
	HashMap<String, Integer> orders;

	Customer3() {
		orders = new HashMap<>();
	}

	void customerFunctions() {
		System.out.print("Enter 1 to order , 2 to display order , 3 to display bill , 4 to exit : ");
		String ord = sc.next();
		switch (ord) {
		case "1":
			System.out.print("Enter you order and quantity : ");
			  while(!sc.hasNext("done")) {
			     String foodItem = sc.next();
			     if (menu.containsKey(foodItem)) {
			    	System.out.print("quantity = ");
			       	int quantity = sc.nextInt();
			       	
			    	orders.put(foodItem, quantity);
			     } else {
			    	System.out.println("not present in the menu");
			     }
			  }
			System.out.print("Do you want anything else : ");
			sc.next();
			String decision = sc.next();
			if (decision.toLowerCase().equals("yes")) {
				customerFunctions();
			} else {
				if(orders.isEmpty()) {
					System.out.println("Please order something");
					customerFunctions();
				}
				else {
				    System.out.println("Order Placed Successfully");
				    customerFunctions();
				}
			}
			break;
		case "2":
			displayOrders();
			customerFunctions();
			break;
		case "3":
			bill();
			break;
		case "4":
			custExit();
			break;
		default:
			System.out.println("Enter valid option");
			customerFunctions();
		}
	
	}
	void displayOrders() {
		if(orders.size() == 0) {
			System.out.println("-----No orders placed-----");
		}
		else {
			Set<String> items = orders.keySet();
			System.out.println("your orders");
			for(String n : items) {
				System.out.println("FoodItem : "+n+" , Quantity : "+orders.get(n));
			}
		}
	}
    void bill() {
    	if(orders.size() == 0) {
			System.out.println("-----No orders placed to generate bill-----");
			customerFunctions();
		}
    	else {
    	Set<String> items = orders.keySet();
    	double bill = 0;
    	for(String n : items) {
    		bill+=(menu.get(n) * orders.get(n));
    	}
    	System.out.println("Your bill for food items "+items+" is "+ bill+" rupees");
    	}
    }
    void custExit() {
    	System.out.println("Thanks visit again");
    }
}
