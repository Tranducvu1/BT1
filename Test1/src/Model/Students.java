package Model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Students {
	ArrayList<Student> stlist = new ArrayList();
	public Students() {
		stlist = new ArrayList();
	}
	public Students(ArrayList<Student> stlist) {
		this.stlist = stlist;
	}
	public ArrayList<Student> getStlist() {
		return stlist;
	}
	public void setStlist(ArrayList<Student> stlist) {
		this.stlist = stlist;
	}
	public void add(Student st) {
		stlist.add(st);
	}
	public String toString() {
		String ans="";
		for(Student st:stlist) {
			ans = ans+st.toString()+"\n";
		}
		return ans;
	}
	public Students sua(int id, Student st) {
		for(int i = 0; i < stlist.size(); i++) {
			if(id == stlist.get(i).getId()) {
				stlist.set(i, st);
			}
		}
		return new Students(stlist);
	}
	public Students xoa(int id) {
		for(int i = 0; i < stlist.size(); i++) {
			if(id == stlist.get(i).getId()) {
				stlist.remove(i);
			}
		}
		return new Students(stlist);
	}

}