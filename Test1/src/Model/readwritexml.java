package Model;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import Model.Students;

public class readwritexml {
	public Students read() throws JAXBException {
		
		Students stlistread = new Students();
		JAXBContext context = JAXBContext.newInstance(Students.class);
		Unmarshaller unmar = context.createUnmarshaller();
		stlistread =(Students) unmar.unmarshal(new File("data.xml"));
		return stlistread;
	}
	public void write(Students stlistwrite) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Students.class);
		Marshaller mar = context.createMarshaller();
		mar.marshal(stlistwrite, new File("data.xml"));
	}
	
}


