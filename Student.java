public class Student{
	private int id;
	private String name;
	private java.util.Date dateCreated;

	private Student(String name){
		this.name = name;
	}
	
	public Student(int ssn, String newName){
		id = ssn;
		name = newName;
		dateCreated = new java.util.Date();
	}
	
	public java.util.Date getDateCreated(){  // 返回一个可变对象的引用不安全
		return (java.util.Date)dateCreated.clone();
	}
}