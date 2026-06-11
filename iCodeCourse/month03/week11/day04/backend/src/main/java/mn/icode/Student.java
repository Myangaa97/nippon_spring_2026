package mn.icode;

public class Student implements Comparable<Student> {
	String name;
	double gpa;
	
	Student(String name, double gpa) {
		this.name = name;
		this.gpa = gpa;
	}
	
	@Override
	public int compareTo(Student other) {
		if(this.gpa > other.gpa) return -1;
		if(this.gpa < other.gpa) return 1;
		return 0;
	}
	
	@Override
	public String toString() {
		return name + " (" + gpa + ") ";
	}
}