package View;


//import java.util.List;
import java.util.Scanner;

import Model.Student;


public class Validate {
	  public static int menu() {
	        System.out.println("------------------------------------");
	        System.out.println("\n1. Read XML file");
	        System.out.println("2. Write");
	        System.out.println("3. Exit");
	        System.out.println("------------------------------------");
	        System.out.print("Enter your choice:\n");
	        int choice = checkInputIntLimit(1, 5);
	        return choice;
	    }
	    public static Scanner in = new Scanner(System.in);

	    // Check input int
	    public static int checkInputInt() {
	        while (true) {
	            try {
	                int rs = Integer.parseInt(in.nextLine());
	                return rs;
	            } catch (NumberFormatException ex) {
	                System.err.println("Input integer number!!");
	                System.out.println("Enter again:");
	            }
	        }
	    }

	    // Check input int limit
	    public static int checkInputIntLimit(int min, int max) {
	        // loop until user input correct
	        while (true) {
	            try {
	                int result = Integer.parseInt(in.nextLine().trim());
	                if (result < min || result > max) {
	                    throw new NumberFormatException();

	                }
	                return result;
	            } catch (NumberFormatException e) {
	                System.err.println("Please input number in rage [" + min + ", " + max + "]");
	                System.out.print("Enter again: ");
	            }
	        }
	    }
	    // Chekc input String
	    public static String checkInputString() {
	        while (true) {
	            String rs = in.nextLine().trim();
	            if (!rs.isEmpty()) {
	                return rs;
	            } else {
	                System.out.println("Can not empty!");
	                System.out.println("Please enter again:");
	            }
	        }
	    }

//	     Display list
	    public static void showList(Student student) {
	        System.out.printf("%-20s%-20s%-20s%-20s%-20s%\n", "|Masv", "|Tensv", "|Mark", "|Physical", "|Chemistry");
	       
	            System.out.printf("%-20s%-20s%-20s%-20s%-20s%\n",
	                    "|" + student.getMasv(),
	                    "|" + student.getTensv(),
	                    "|" + student.getMark(),
	                    "|" + student.getPhysical(),
	                    "|" + student.getChemistry());

	        }
	    }
	

  