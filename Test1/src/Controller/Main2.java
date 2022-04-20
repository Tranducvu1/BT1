package Controller;

import java.io.FileNotFoundException;

import javax.xml.stream.XMLStreamException;

import Model.Student;
import View.Validate;

public class Main2 {
	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
		// TODO Auto-generated method stub
		Student order = new Student();
		 System.out.println("Nhap Ma sinh vien:");
         order.setMasv(Validate.checkInputString());
         System.out.println("Nhap ten sinh vien :");
         order.setTensv(Validate.checkInputString());
         System.out.println("Nhap diem toan:");
         order.setMark(Validate.checkInputString());
         System.out.println("Nhap diem ly:");
         order.setPhysical(Validate.checkInputString());
         System.out.println("Nhap diem hoa:");
         order.setChemistry(Validate.checkInputString());
         WriteStaxCursor write = new WriteStaxCursor();
         write.writeXML("src\\XML\\student.xml",order);
	}

}
