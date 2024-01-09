import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetStudent {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				                .addAnnotatedClass(StudentDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		System.out.println("session has started");
		Student tempStudent=(Student) session.get(Student.class, 1);
		System.out.println(tempStudent);
		List<Course> courses=tempStudent.getCourse();
		for(Course x:courses) {
			System.out.println(x);
		}
		session.getTransaction().commit();
		System.out.println("session has ended");

	}

}
