package Model;

import java.util.Scanner;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	 int id;
	 String name;
	 String age;
	 public Student() {
		 this.id = 0;
		 this.name = "";
		 this.age = "";
	 }
	 public Student(int id, String name, String age) {
		 this.id = id;
		 this.name = name;
		 this.age = age;
	 }
	public int getId() {
		return id;
	}
	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	@XmlElement
	public void setAge(String age) {
		this.age = age;
	}
	public String toString() {
		return "id ="+this.id+" name = "+this.name+" age = "+this.age;
	}
	public Student them() {
		Student st = new Student();
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap id ");
		st.id = sc.nextInt();
		sc.nextLine();
		System.out.println("nhap ten ");
		st.name = sc.nextLine();
		System.out.println("nhap tuoi ");
		st.age = sc.nextLine();
		return st;
	}
	

}