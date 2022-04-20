package Model;

//import java.awt.print.Book;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlType(namespace="http://www.example.org/type")
@XmlRootElement(name = "studen")
public class Students 
{

  @XmlElement(name = "student")
  private List<Student> students = null;
 
  public List<Student> getstudent() {
    return students;
  }
  public void setStudent(List<Student> Students) {
    this.students=Students;
  }
}
