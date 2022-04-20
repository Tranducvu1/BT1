package Controller;

import java.io.File;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


import Model.Student;
import Model.Students;

import View.Validate;
import Model.readwritexml;



public class Main {

	public static void main(String[] args) throws JAXBException {
		Scanner sc = new Scanner(System.in);
		readwritexml rwx = new readwritexml();
	
		Students stlist = rwx.read();
		Student st = new Student();
		Validate m= new Validate();
		// TODO Auto-generated method stub
//		studentList stlist = new studentList();
//		studentList stlistread = new studentList();
//		stlist.add(new student(1,"Linh","19"));
//		stlist.add(new student(2,"Haizuka","20"));
//		JAXBContext context = JAXBContext.newInstance(studentList.class);
//		Marshaller mar = context.createMarshaller();
//		mar.marshal(stlist, new File("data.xml"));
//		Unmarshaller unmar = context.createUnmarshaller();
//		stlistread =(studentList) unmar.unmarshal(new File("data.xml"));
//		System.out.println(stlistread);
		int choose;
		do {
			choose = m.Display();
			switch (choose){
				case 1:
					System.out.println(rwx.read());
					break;
				case 2: 
					stlist.add(st.them());
					rwx.write(stlist);
					break;
				case 3:
					System.out.println("nhap id cua sinh vien can sua ");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.println("nhap thong tin moi ");
					st = st.them();
					stlist = stlist.sua(id, st);
					rwx.write(stlist);
					break;
				case 4:
					System.out.println("nhap id cua sinh vien can xoa ");
					int id2 = sc.nextInt();
					sc.nextLine();
					stlist = stlist.xoa(id2);
					rwx.write(stlist);
					break;
			}
			
		}while(choose!=5);
	}

}


