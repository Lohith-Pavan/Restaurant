package CollectionsProjects;

import java.util.*;

public class Owner3 {
	HashMap<String, Double> menu;
	Scanner sc = new Scanner(System.in);
    boolean flag = false;
	Owner3() {
		menu = new HashMap<>();
		menu.put("idli", 30.00);
		menu.put("dosa", 25.00);
		menu.put("bonda", 30.00);
	}
	void owner() {
		int i = 0;
		while (i < 3) {
			System.out.print("Enter Username : ");
			String username = sc.next();
			System.out.print("Enter Password : ");
			String password = sc.next();
			this.flag = authentication(username, password);
			i++;
			if (flag) {
				break;
			}
		}
	}
	boolean authentication(String userName, String password) {
		Scanner sc = new Scanner(System.in);
		if (userName.equals("LohithPavan") && password.equals("Pavan@123")) {
			ownerFunctions();
			return true;
		}

		else {
			System.out.println("Incorrect username or password");
			return false;
		}
	}

	void ownerFunctions() {
		System.out.print("Enter 1 to add item , Enter 2 to remove item , Enter 3 to change price , Enter 4 to exit : ");
		int menu = sc.nextInt();
		switch (menu) {
		case 1:
			addItem();
			break;
		case 2:
			removeItem();
			break;
		case 3:
			changePrice();
			break;
		case 4:
			exit();
			break;
		default:
			System.out.println("Enter correct option");
			break;
		}
	}


	void addItem() {
		System.out.print("Enter food Item : ");
		String Item = sc.next();
		if (menu.containsKey(Item.toLowerCase())) {
			System.out.println(Item + " is in Menu");
			System.out.print("Do you want to add more items to menu: ");
			String decision = sc.next();
			if (decision.toLowerCase().equals("yes")) {
				addItem();
			} else if (decision.toLowerCase().equals("no")) {
				ownerFunctions();
			}
		} else {
			System.out.print("Enter price : ");
			double Price = sc.nextDouble();
			menu.put(Item.toLowerCase(), Price);
			System.out.println(Item + " added successfully");
			System.out.print("Do you want to add more items to menu: ");
			String decision = sc.next();
			if (decision.toLowerCase().equals("yes")) {
				addItem();
			} else if (decision.toLowerCase().equals("no")) {
				ownerFunctions();
			}
		}
	}

	void removeItem() {
		System.out.print("Enter food Item : ");
		String Item = sc.next();
		if (menu.containsKey(Item.toLowerCase())) {
			menu.remove(Item);
			System.out.println(Item + " removed successfully");
			System.out.print("Do you want to remove more items from menu: ");
			String decision = sc.next();
			if (decision.toLowerCase().equals("yes")) {
				removeItem();
			} else if (decision.toLowerCase().equals("no")) {
				ownerFunctions();
			}

		} else {
			System.out.println(Item + " is not present in menu");
			System.out.print("Do you want to remove more items from menu: ");
			String decision = sc.next();
			if (decision.toLowerCase().equals("yes")) {
				removeItem();
			} else if (decision.toLowerCase().equals("no")) {
				ownerFunctions();
			}
		}
	}

	void changePrice() {
		System.out.print("Enter food Item : ");
		String item = sc.next();
		if (menu.containsKey(item)) {
			System.out.print("Enter New Price : ");
			double price = sc.nextDouble();
			if (menu.containsKey(item)) {
				menu.put(item, price);
			}
			System.out.println(item + " price changed successfully");
			System.out.print("Do you want to change more items price from menu: ");
			String decision = sc.next();
			if (decision.toLowerCase().equals("yes")) {
				changePrice();
			} else if (decision.toLowerCase().equals("no")) {
				ownerFunctions();
			}
		} else {
			System.out.println(item + " is not in menu");
			System.out.print("Do you want to change more items price from menu: ");
			String decision = sc.next();
			if (decision.toLowerCase().equals("yes")) {
				changePrice();
			} else if (decision.toLowerCase().equals("no")) {
				ownerFunctions();
			}
		}
	}
	void exit() {
		System.out.println("Logged out");
	}
}
