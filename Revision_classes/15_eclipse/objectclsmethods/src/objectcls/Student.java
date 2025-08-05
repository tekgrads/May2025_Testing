package objectcls;

import java.util.Objects;

public class Student {
	private Integer sno;
	private String name;
	private String course;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Student(int sno, String name, String course) {
		super();
		this.sno = sno;
		this.name = name;
		this.course = course;
	}
	public Student() {
		
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", name=" + name + ", course=" + course + "]";
	}
	@Override
	public int hashCode() {
	//	return sno.toString().hashCode()+ name.hashCode()+course.hashCode();
		return course.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student s = (Student)obj;
		//	return this.sno == s.sno && this.name == s.name 
			//		&& this.course== s.course;
			return this.sno == s.sno 
					&& this.course== s.course;
		}
		return false;
	}
	public static void main(String[] args) {
		Student s1 = new Student(101, "Abc", "java");
		Student s2 = new Student(101, "Abc", "java");
		Student s3 = new Student(102, "Abc", "java");
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
	
	}

}
