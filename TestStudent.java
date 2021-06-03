public class TestStudent{
	public static void main(String[] args){
		Student student = new Student(12313, "jack");
		java.util.Date dateCreated = student.getDateCreated();
		System.out.println(dateCreated);
		dateCreated.setTime(200000);
		System.out.println(student.getDateCreated());
	}
}