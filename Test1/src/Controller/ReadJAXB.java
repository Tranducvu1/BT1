package Controller;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.w3c.dom.Node;

import View.Validate;
import Model.Student;
//import Model.Students;


@SuppressWarnings("unused")
public class ReadJAXB {
	public void readJABX(String src) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        File file = new File(src);
  //     Student student = (Student) jaxbUnmarshaller.unmarshal(file);
        Student student = (Student) jaxbUnmarshaller.unmarshal(new File("src\\\\XML\\\\student.xml"));;
       Validate.showList(student);
    }
    
    public void readStudentListXML(String src) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        File file = new File(src);
        Student Students = (Student) jaxbUnmarshaller.unmarshal(file);
        System.out.println(Students);
    }
}
