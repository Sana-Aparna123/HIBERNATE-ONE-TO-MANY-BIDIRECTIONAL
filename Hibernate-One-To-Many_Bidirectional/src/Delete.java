import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				                .addAnnotatedClass(Student.class)
				                .addAnnotatedClass(StudentDetail.class)
				                .addAnnotatedClass(Course.class)
				                .addAnnotatedClass(Review.class)
				                .buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		System.out.println("session has started");
		session.beginTransaction();
		Student tempStudent=(Student) session.get(Student.class, 1);
		List<Course> tempCourse=tempStudent.getCourse();
		session.delete(tempCourse.remove(1));
		session.getTransaction().commit();
		System.out.println("session has ended");	                
	}

}
