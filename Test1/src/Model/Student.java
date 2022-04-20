
package Model;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace="http://www.example.org/type")
@XmlRootElement(name = "student")
public class Student {


    private String masv;

    private String tensv;

    private  String mark;
    private String physical;
    private String chemistry;

	public Object xml;



	
	  public Student() { super(); }
	 
    
    public Student(String masv,String tensv,String mark,String physical,String chemistry) {
        super();
        this.masv = masv;
        this.tensv = tensv;
        this.mark=mark;

    }
	public String getMasv() {
		return masv;
	}

	public void setMasv(String masv) {
		this.masv = masv;
	}

	public String getTensv() {
		return tensv;
	}

	public void setTensv(String tensv) {
		this.tensv = tensv;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getPhysical() {
		return physical;
	}

	public void setPhysical(String physical) {
		this.physical = physical;
	}

	public String getChemistry() {
		return chemistry;
	}

	public void setChemistry(String chemistry) {
		this.chemistry = chemistry;
	}


    
    @Override
    public String toString() {
        return "Students{" + "name=" + tensv + ", mark=" + mark+ ", physical=" + physical + "chemistry=" + chemistry+ '}';
    }

	


}