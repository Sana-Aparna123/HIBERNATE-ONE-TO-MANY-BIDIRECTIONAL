
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertReview {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(StudentDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		System.out.println("session has started");
		Course tempCourse = (Course) session.get(Course.class, 10);

		Review tempReview1 = new Review("Good");
		Review tempReview2 = new Review("Average");
		Review tempReview3 = new Review("Bad");

		tempCourse.addReview(tempReview1);
		tempCourse.addReview(tempReview2);
		tempCourse.addReview(tempReview3);

		session.save(tempReview1);
		session.save(tempReview2);
		session.save(tempReview3);

		session.getTransaction().commit();
		System.out.println("session has ended");

	}

}
