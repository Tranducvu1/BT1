package Controller;


import java.io.File;
//import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import Model.Student;
//import Model.Students;
import View.Validate;

public class AddNew {
    public static void addXML(String src, Student newStudent) throws JAXBException{
    	   JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
           Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

           File file = new File(src);
           Student Student = (Student) jaxbUnmarshaller.unmarshal(file);
           Validate.showList(Student); 
//           System.out.println(order);
       }      
       public void readOrderListXML(String src) throws JAXBException {
           JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
           Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

           File file = new File(src);
          Student student = (Student) jaxbUnmarshaller.unmarshal(file);
           System.out.println(student);
       }
   }


