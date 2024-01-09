import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertStudent {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(StudentDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		System.out.println("session has started");
		//get student details based on id in student class
		Student tempStudent=(Student) session.get(Student.class, 1);
		
		//creating course object
		Course tempCourse1=new Course("Java");
		Course tempCourse2=new Course("Python");
		Course tempCourse3=new Course("C#");
		
		//adding courses in student object
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);
		tempStudent.addCourse(tempCourse3);
		
		//save the course objects
		session.save(tempCourse1);
		session.save(tempCourse2);
		session.save(tempCourse3);
		
		session.getTransaction().commit();
		System.out.println("session has ended");
	}

}
