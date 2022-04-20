package Controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//import java.io.OutputStream;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import Model.Student;

public class WriteStaxCursor {

    public void writeXML(String src, Student order) throws XMLStreamException, FileNotFoundException {
        XMLOutputFactory factory = XMLOutputFactory.newFactory();
        XMLEventWriter writer = factory.createXMLEventWriter(new FileOutputStream(src), "UTF-8");
        XMLEventFactory eventFactory = XMLEventFactory.newFactory();

        XMLEvent event = eventFactory.createStartDocument("UTF-8", "1.0");

        writer.add(event);
         
        //writer.add(eventFactory.createStartElement("", "", "Sinh_vien"));

        
        writer.add(eventFactory.createStartElement("", "", "Ma_sinh_vien"));
        writer.add(eventFactory.createCharacters(order.getMasv()));
     //   writer.add(eventFactory.createEndElement("", "", "Ma_sinh_vien"));

        writer.add(eventFactory.createStartElement("", "", "Ten_sinh_vien"));
        writer.add(eventFactory.createCharacters(order.getTensv()));
        writer.add(eventFactory.createEndElement("", "", "Ten_sinh_vien"));

        writer.add(eventFactory.createStartElement("", "", "Mark"));
        writer.add(eventFactory.createCharacters(order.getMark()));
        writer.add(eventFactory.createEndElement("", "", "Mark"));

        writer.add(eventFactory.createStartElement("", "", "Physical"));
        writer.add(eventFactory.createCharacters(order.getPhysical()));
        writer.add(eventFactory.createEndElement("", "", "Physical"));

        writer.add(eventFactory.createStartElement("", "", "Chemistry"));
        writer.add(eventFactory.createCharacters(order.getChemistry()));
        writer.add(eventFactory.createEndElement("", "", "Chemistry"));
        writer.add(eventFactory.createStartElement("", "", "student"));
        writer.add(eventFactory.createEndElement("", "", "student"));
        
        writer.add(eventFactory.createEndElement("", "", "Ma_sinh_vien"));
       // writer.add(eventFactory.createEndElement("", "", "Sinh_vien"));
        writer.add(eventFactory.createEndDocument());

        writer.flush();

        writer.close();

    }

	

	
	


    }
