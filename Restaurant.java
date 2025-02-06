package CollectionsProjects;

import java.util.*;

public class Restaurant {
	Scanner sc = new Scanner(System.in);
    void restaurant() {
    	Owner3 ob = new Owner3();
		Customer3 op = new Customer3();
    	System.out.print("Enter 1 for admin and 2 for customer and 3 for exit: ");
		int person = sc.nextInt();
		switch (person) {
		case 1:
			ob.owner();
			if(ob.flag == true) {	
				restaurant();
			}
			break;
		case 2:
			op.customerFunctions();
			restaurant();
			break;
		case 3:
			System.out.println("------Session terminated-------");
			break;
		default:
			System.out.println("enter correct option");
			restaurant();
		}
    }
	public static void main(String args[]) {
		Restaurant res = new Restaurant();
		res.restaurant();
	}
}
