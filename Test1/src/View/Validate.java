package View;


//import java.util.List;
import java.util.Scanner;

import Model.Student;


public class Validate {
	public int Display() {
		System.out.println("<!--------!>");
		System.out.println("1-Display");
		System.out.println("2-Enter");
		System.out.println("3-Update");
		System.out.println("4-Delete");
		System.out.println("<!--------!>");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		return n;
	}

}
