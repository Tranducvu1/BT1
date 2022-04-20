
package Controller;

import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

public class Main {
	 public static void main(String[] args) throws JAXBException, XMLStreamException, FileNotFoundException {
	        // TODO code application logic here
		/* Student student = new Student();
		 student.setMasv("21IT324");
	        while (true) {
	            int choice = Validate.menu();
	            switch (choice) {
	                case 1:*/
	                    ReadJAXB read = new ReadJAXB();
	                    read.readJABX("src\\\\\\\\XML\\\\\\\\student.xml");
                       // read.readJABX("src\\XML\\student.xml");
	              /*  default:
	                
	                    System.out.println("Does not exist with the entered ID");
	                    System.out.println("Try again");
	                    break;
	            }
	        }
	    }*/
	}
}